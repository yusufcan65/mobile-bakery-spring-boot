package mobilF.r.n.uygulama.businness.requests.User;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ManagerRequest implements UserRequest {

    @NotNull
    @NotBlank
    private String type="Manager";
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
}
