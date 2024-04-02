package mobilF.r.n.uygulama.businness.responses.Adresler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAdreslerResponse {

    private int id;
    private String City;
    private String district;
    private String street;
    private int number;
    private String Postcode;
}
