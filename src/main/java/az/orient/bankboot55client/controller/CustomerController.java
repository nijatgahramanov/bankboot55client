package az.orient.bankboot55client.controller;

import az.orient.bankboot55client.api.request.ReqCustomer;
import az.orient.bankboot55client.api.request.ReqToken;
import az.orient.bankboot55client.api.response.RespCustomerList;
import az.orient.bankboot55client.api.response.Response;
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

    @GetMapping("/getCustomerList")
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
            if (respCustomerList.getStatus().getCode() == 1 || respCustomerList.getStatus().getCode()==107) {
                model.addObject("customerList", respCustomerList.getResponse());
            } else {
                model.addObject("msg", respCustomerList.getStatus().getMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return model;
    }

    @GetMapping("/newCustomer")
    public ModelAndView newCustomer() {
        ModelAndView model = new ModelAndView("customer/newCustomer");
        return model;
    }

    @PostMapping("/addCustomer")
    public @ResponseBody
    String addCustomer(@RequestBody ReqCustomer reqCustomer) {
        String response = "error";
        try {
            RespUser respUser = (RespUser) request.getSession(false).getAttribute("respUser");
            ReqToken reqToken = new ReqToken();
            reqToken.setId(respUser.getRespToken().getUserId());
            reqToken.setToken(respUser.getRespToken().getToken());
            reqCustomer.setReqToken(reqToken);

            String reqJson = objectMapper.writeValueAsString(reqCustomer);
            String result = utility.sendPost(apiUrl + "customer/AddCustomer", "reqJson");
            Response respStatusList = objectMapper.readValue(result, Response.class);
            System.out.println("response : "+respStatusList);
            if (respStatusList.getStatus().getCode() == 1) {
                response = "success";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return response;
    }


}
