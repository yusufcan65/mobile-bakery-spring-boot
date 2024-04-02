package mobilF.r.n.uygulama.businness.requests.Adresler;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdreslerRequest {

    @NotNull
    @NotBlank
    @Size(min=3, max = 30)
    private String City;

    @NotNull
    @NotBlank
    @Size(min=3, max = 30)
    private String District;

    @NotNull
    @NotBlank
    @Size(min=3, max = 30)
    private String postcode;

    @NotNull
    private int number;

    @NotNull
    @NotBlank
    @Size(min=3, max = 30)
    private String street;

}
