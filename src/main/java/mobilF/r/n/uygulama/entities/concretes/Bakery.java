package mobilF.r.n.uygulama.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Bakery")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bakery{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

   @Column(name = "Name")
    private String name;

    @Column(name = "phonenumber")
    private String PhoneNumber;

    //burdan sonra ilşkiler yer alır


    @OneToMany(mappedBy = "bakery")
    private List<Urunler> urunler;




    @ManyToOne//bunun işi bitti
    @JoinColumn(name = "adresler_id")
    private Adresler adresler;


    @OneToOne(mappedBy = "bakery")//bunun işi bitti
    private Seller seller;
}



