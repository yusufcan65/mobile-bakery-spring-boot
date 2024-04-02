package mobilF.r.n.uygulama.businness.responses.User;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerResponse implements UserResponse{

    private int id;
    private String name;
    private String surname;
    private String username;
    private String password;
    private String eMail;
    private int bakeryId;
}
