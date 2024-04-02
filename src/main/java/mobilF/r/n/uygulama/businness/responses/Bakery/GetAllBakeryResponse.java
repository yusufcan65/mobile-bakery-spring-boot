package mobilF.r.n.uygulama.businness.responses.Bakery;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBakeryResponse {

    private int id;
    private String name;
    private String phoneNumber;
    private int adreslerId;
}
