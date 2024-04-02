package mobilF.r.n.uygulama.businness.requests.Urunler;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUrunlerRequest {

    private int id;

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    private float Price;
}
