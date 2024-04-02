package mobilF.r.n.uygulama.businness.responses.Kampanya;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByIdKampanyaResponse {
    private int id;
    private String name;
    private Date expirydate;
}
