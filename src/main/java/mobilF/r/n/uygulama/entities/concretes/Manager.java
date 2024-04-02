package mobilF.r.n.uygulama.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Manager")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Manager extends User {

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

    // burdan sonra ilşkiler yer alır

    @OneToMany(mappedBy = "manager")
    private List<Kampanyalar> kampanyalar;



}
