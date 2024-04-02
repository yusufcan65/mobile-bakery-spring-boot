package mobilF.r.n.uygulama.businness.requests.Kampanya;

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
public class CreateKampanyaRequest {

    @NotBlank
    @NotNull
    private String name;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date expirydate;

    @NotNull
    private int customerId;
    @NotNull
    private int managerId;

}
