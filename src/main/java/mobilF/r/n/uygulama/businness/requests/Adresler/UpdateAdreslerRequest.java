package mobilF.r.n.uygulama.businness.requests.Adresler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdreslerRequest {

    private int id;
    private String city;
    private String district;
    private String postcode;
    private int number;
    private String street;
}
