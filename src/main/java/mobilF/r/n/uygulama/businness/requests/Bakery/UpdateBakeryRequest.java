package mobilF.r.n.uygulama.businness.requests.Bakery;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBakeryRequest {

    private int id;
    private String name;
    private String PhoneNumber;
}
