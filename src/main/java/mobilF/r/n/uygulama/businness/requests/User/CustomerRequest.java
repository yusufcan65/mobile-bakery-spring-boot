package mobilF.r.n.uygulama.businness.requests.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CustomerRequest implements UserRequest{


    @NotNull
    @NotBlank
    private String type = "Customer";
    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String surname;
    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String phonenumber;
    @NotNull
    @NotBlank
    private String eMail;
    @NotNull
    private Integer adreslerId;
}
