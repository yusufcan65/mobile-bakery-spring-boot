package mobilF.r.n.uygulama.businness.requests.Siparis;


import jakarta.validation.constraints.NotNull;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class CreateSiparisRequest {

    @NotNull
    private int urunsayısı;

    @NotNull
    private int urunlerId;//

    @NotNull
    private int customerId;//

    @NotNull
    private int kuryeId;//
    @NotNull
    private int kampanyalarId;//

    @NotNull
    private int kartlarId;//






}
