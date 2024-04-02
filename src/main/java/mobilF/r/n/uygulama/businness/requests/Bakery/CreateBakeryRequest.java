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
public class CreateBakeryRequest {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @NotBlank
    private String phoneNumber;

    @NotNull
    private int adreslerId;



}
