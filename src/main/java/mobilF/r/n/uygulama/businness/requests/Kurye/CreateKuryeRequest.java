package mobilF.r.n.uygulama.businness.requests.Kurye;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateKuryeRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String surname;

}
