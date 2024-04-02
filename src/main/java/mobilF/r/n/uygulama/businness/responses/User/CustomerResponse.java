package mobilF.r.n.uygulama.businness.responses.User;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class CustomerResponse implements UserResponse {

    private int id;
    private String name;
    private String surname;
    private String username;
    private String eMail;
    private String phonenumber;
    private String adreslerCity;


}
