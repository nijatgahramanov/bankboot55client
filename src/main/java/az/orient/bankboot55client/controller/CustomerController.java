package az.orient.bankboot55client.controller;

import az.orient.bankboot55client.api.request.ReqToken;
import az.orient.bankboot55client.api.response.RespCustomer;
import az.orient.bankboot55client.api.response.RespCustomerList;
import az.orient.bankboot55client.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/client")
public class CustomerController {

    @Value("${api.url}")
    private String apiUrl;

    @Value("${api.userId}")
    private String apiUserId;

    @Value("${api.token}")
    private String apiToken;

    private final Utility utility;

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
    public @ResponseBody
    String getCustomerList() {
        try {
            String url = apiUrl + "customer/GetCustomerList";
            ReqToken reqToken = new ReqToken();
            reqToken.setUserId(Long.valueOf(apiUserId));
            reqToken.setToken(apiToken);
            String reqTokenJson = objectMapper.writeValueAsString(reqToken);
            String result = utility.sendPost(url, reqTokenJson);
            System.out.println(result);
            RespCustomerList respCustomerList = objectMapper.readValue(result, RespCustomerList.class);
            if (respCustomerList.getStatus().getCode() == 1) {
                System.out.println(respCustomerList.getResponse());
            } else {
                System.out.println(respCustomerList.getStatus().getMessage());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "success";
    }


}
