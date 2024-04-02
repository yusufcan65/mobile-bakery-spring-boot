package mobilF.r.n.uygulama.businness.requests.Siparis;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateSiparisRequest {

    private int id;
    private float amount;
}
