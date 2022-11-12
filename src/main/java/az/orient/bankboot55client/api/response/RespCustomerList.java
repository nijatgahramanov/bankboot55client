package az.orient.bankboot55client.api.response;

import lombok.Data;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Data
public class RespCustomerList {

    private List<RespCustomer> response;
    private RespStatus status;

}
