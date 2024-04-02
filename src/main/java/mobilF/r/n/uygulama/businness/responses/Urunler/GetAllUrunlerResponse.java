package mobilF.r.n.uygulama.businness.responses.Urunler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUrunlerResponse {
    private int id;
    private String name;
    private float price;
    private int bakeryId;
    private String bakeryName;
}
