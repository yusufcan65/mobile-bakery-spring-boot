package mobilF.r.n.uygulama.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Table(name = "Urunler")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Urunler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "Price")
    private float price;


    // burdan sonra ilişkiler başlar

    @OneToMany(mappedBy = "urunler")
    private List<Siparis> siparis;

    @ManyToOne
    @JoinColumn(name = "bakery_id")
    private Bakery bakery;



}
