package mobilF.r.n.uygulama.businness.requests.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerRequest implements UserRequest{

    @NotNull
    @NotBlank
    private String type="Seller";
    @NotNull
    @NotBlank
    private String name;
    @NotBlank
    @NotNull
    private String surname;

    @NotNull
    @NotBlank
    private String username;
    @NotNull
    @NotBlank
    private String password;
    @NotNull
    @NotBlank
    private String eMail;
    @NotNull
    private Integer bakeryId;

}
