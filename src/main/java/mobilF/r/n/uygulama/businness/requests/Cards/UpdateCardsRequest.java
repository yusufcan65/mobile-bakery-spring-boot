package mobilF.r.n.uygulama.businness.requests.Cards;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCardsRequest {
    private int id;
    private String cartname;
    private String cvc;
    private int cartno;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date expirydate;

}
