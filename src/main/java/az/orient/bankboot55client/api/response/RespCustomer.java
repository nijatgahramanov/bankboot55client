package az.orient.bankboot55client.api.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RespCustomer {

    private Long customerId;
    private String username;
    private String password;
    private String name;
    private String surname;
    private String phone;
    private Date dob;
    private String cif;
    private String pin;
    private String seria;

}
