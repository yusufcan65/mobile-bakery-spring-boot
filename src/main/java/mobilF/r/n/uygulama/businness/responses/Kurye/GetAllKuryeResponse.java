package mobilF.r.n.uygulama.businness.responses.Kurye;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllKuryeResponse {
    private int id;
    private String name;
    private String surname;
}
