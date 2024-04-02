package mobilF.r.n.uygulama.businness.requests.Urunler;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateUrunlerRequest {
    @NotNull
    private String name;
    @NotNull
    private float Price;

    @NotNull
    private int bakeryId;



}
