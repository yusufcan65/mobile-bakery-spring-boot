package mobilF.r.n.uygulama.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Table(name = "Kampanyalar")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Kampanyalar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "expirydate")
    private Date expirydate;

    //burdan sonra ilşkiler yer alır

    @ManyToOne
    @JoinColumn(name = "customer_id")//bunun işi bitti
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Manager manager;

    @OneToMany(mappedBy = "kampanyalar")
    private List<Siparis> siparis;



}
