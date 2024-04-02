package mobilF.r.n.uygulama.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Table(name = "Kartlar")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kartlar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @SequenceGenerator(name = "Kartlar",sequenceName = "KARTLAR_ID_SEQ",allocationSize = 1)
    private int id;

    @Column(name = "cartname")
    private String cartname;

    @Column(name = "cartno")
    private int cartno;

    @Column(name = "CVC")
    private int cvc;

    @Column(name = "expirydate")
    private Date expirydate;

    @Column(name = "kartlimit")
    private float kartlimit;


    // burdan sonrav ilşkiler başlar

    @ManyToOne
    @JoinColumn(name = "customer_id")//bunun işi bitti
    private Customer customer;

    @OneToMany(mappedBy = "kartlar")// bunun işi bitti
    private List<Siparis> siparis;

}