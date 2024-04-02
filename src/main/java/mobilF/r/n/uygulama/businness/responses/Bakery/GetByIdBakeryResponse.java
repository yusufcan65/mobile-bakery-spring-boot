package mobilF.r.n.uygulama.businness.responses.Bakery;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetByIdBakeryResponse {

    private int id;
    private String Name;
    private String phonenumber;
}
