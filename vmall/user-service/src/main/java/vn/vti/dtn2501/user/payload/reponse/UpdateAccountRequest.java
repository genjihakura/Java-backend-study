package vn.vti.dtn2501.user.payload.reponse;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateAccountRequest {

    private String username;
    private String password;
    private String phone;
    private String email;
}
