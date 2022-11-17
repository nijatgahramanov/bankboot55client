package az.orient.bankboot55client.api.request;

import lombok.Data;

@Data
public class ReqToken {
    private Long userId;
    private String token;

}
