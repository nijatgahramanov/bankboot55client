package az.orient.bankboot55client.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Base64;

@Component
public class Utility {

    @Value("api.usr")
    String apiUsr;

    @Value("api.pwd")
    String apiPwd;

    public HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-type", "application/json");
        httpHeaders.add("Accept", "application/json");
        String auth = apiUsr + ":" +apiPwd;
        String base64Creds = Base64.getEncoder().encodeToString(auth.getBytes());
        httpHeaders.add("Authorization","Basic "+ base64Creds);
        return httpHeaders;
    }


    public String sendGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        return result.getBody();
    }

    public String sendPost(String url, String data) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> result = restTemplate.postForEntity(url, new HttpEntity<>(data, getHeaders()), String.class);
        return result.getBody();
    }


}
