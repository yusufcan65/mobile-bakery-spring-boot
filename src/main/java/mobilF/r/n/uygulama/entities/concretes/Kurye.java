package mobilF.r.n.uygulama.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Kurye")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kurye {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    //burdan sonra ilşkiler yer alır

    @OneToMany(mappedBy = "kurye")
    private List<Siparis> siparis;






}
