package mobilF.r.n.uygulama.businness.responses.Cards;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCardsResponse {

    private int id;
    private String cartname;
    private String cvc;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date expirydate;

    private int cartno;
    private float kartlimit;

    private int customerId;
}
