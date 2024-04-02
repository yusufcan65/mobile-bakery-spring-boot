package mobilF.r.n.uygulama.entities.concretes;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Table(name = "Customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer extends User {

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

    @Column(name = "PhoneNumber")
    private String phonenumber;

    @Column(name = "email")
    private String eMail;


    // ilşkiler burada yer alır



    @OneToMany(mappedBy = "customer")//bunun işi bitti
    private List<Kartlar> kartlar;


    @ManyToOne
    @JoinColumn(name = "adresler_id")//bunun işi bitti
    private Adresler adresler;


    @OneToMany(mappedBy = "customer")
    private List<Siparis> siparis;

    @OneToMany(mappedBy = "customer")//bunun işi bitti
    private List<Kampanyalar> kampanyalar;



}
