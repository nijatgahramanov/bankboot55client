package az.orient.bankboot55client.api.response;

import lombok.Data;

@Data
public class RespUser {

    String username;
    String fullName;
    RespStatus status;
    RespToken respToken;

}
