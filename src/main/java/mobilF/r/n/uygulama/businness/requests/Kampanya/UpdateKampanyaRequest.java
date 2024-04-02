package mobilF.r.n.uygulama.businness.requests.Kampanya;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateKampanyaRequest {
    @NotNull
    private int id;

    @NotNull
    @NotBlank

    private String name;

    @NotNull
    private Date expirydate;
}
