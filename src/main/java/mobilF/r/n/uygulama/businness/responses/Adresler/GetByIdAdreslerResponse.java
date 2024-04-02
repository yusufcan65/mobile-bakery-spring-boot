package mobilF.r.n.uygulama.businness.responses.Adresler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByIdAdreslerResponse {

    private int adresid;
    private String City;
    private String district;
    private String street;
    private int number;
    private String Postcode;

}
