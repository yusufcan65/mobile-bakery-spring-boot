package mobilF.r.n.uygulama.businness.responses.Kampanya;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetByKampanyaNameResponse {
    private int id;
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date expirydate;

    private int customerId;
    private int managerId;
}
