package az.orient.bankboot55client.controller;

import az.orient.bankboot55client.api.request.ReqToken;
import az.orient.bankboot55client.api.response.RespCustomerList;
import az.orient.bankboot55client.api.response.RespUser;
import az.orient.bankboot55client.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
//@RequestMapping("/client")
public class CustomerController {

    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.userId}")
    private String apiUserId;

    @Value("${api.token}")
    private String apiToken;

    private final Utility utility;

    private final HttpServletRequest request;

    ObjectMapper objectMapper = new ObjectMapper();


    @GetMapping("/GetCustomerById/{customerId}")
    public @ResponseBody
    String getCustomerList(@PathVariable Long customerId) {
        String url = apiUrl + "customer/GetCustomerById/" + apiUserId;
        String result = utility.sendGet(url);
        System.out.println(result);
        return "success";
    }

    @GetMapping("/GetCustomerList")
    public ModelAndView getCustomerList() {
        ModelAndView model = new ModelAndView("index");
        try {
            RespUser respUser = (RespUser) request.getSession(false).getAttribute("respUser");
            String url = apiUrl + "customer/GetCustomerList";
            ReqToken reqToken = new ReqToken();
            reqToken.setId(respUser.getRespToken().getUserId());
            reqToken.setToken(respUser.getRespToken().getToken());
            String reqTokenJson = objectMapper.writeValueAsString(reqToken);
            String result = utility.sendPost(url, reqTokenJson);
            RespCustomerList respCustomerList = objectMapper.readValue(result, RespCustomerList.class);
            if (respCustomerList.getStatus().getCode() == 1) {
                model.addObject("customerList",respCustomerList.getResponse());
            } else {
                model.addObject("msg",respCustomerList.getStatus().getMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }


}
