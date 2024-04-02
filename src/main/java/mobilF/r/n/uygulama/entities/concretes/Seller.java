package mobilF.r.n.uygulama.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Table(name = "Seller")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Seller extends User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "email")
    private String eMail;

    //burdan sonra ilşkiler olur


    @OneToOne
    @JoinColumn(name = "bakery_id")
    private Bakery bakery;
}
