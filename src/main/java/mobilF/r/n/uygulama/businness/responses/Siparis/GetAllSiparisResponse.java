package mobilF.r.n.uygulama.businness.responses.Siparis;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllSiparisResponse {
    private int id;
    private int urunsayısı;
    private float amount;
    private String urunlerName;
    private String customerName;
    private String kuryeName;

}
