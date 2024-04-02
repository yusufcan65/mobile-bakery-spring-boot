package mobilF.r.n.uygulama.businness.requests.Cards;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCardsRequest {

    @NotBlank
    @NotNull
    private String cartname;

    @NotBlank
    @NotNull
    private String cvc;

    @NotNull
    private int cartno;

    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date expirydate;

    private float kartlimit;

    @NotNull
    private int customerId;
}
