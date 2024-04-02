package mobilF.r.n.uygulama.entities.concretes;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Sipariş")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Siparis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "urunsayısı")
    private int urunsayısı;

    @Column(name = "orderamount")
    private float amount;



    //burdan sonrası ilişkiler


    @ManyToOne
    @JoinColumn(name = "urunler_id")
    private Urunler urunler;

    @ManyToOne
    @JoinColumn(name = "kampanyalar_id")
    private Kampanyalar kampanyalar;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @ManyToOne//bunun işi tamam
    @JoinColumn(name = "kurye_id")
    private Kurye kurye;



    @ManyToOne
    @JoinColumn(name = "kartlar_id")
    private Kartlar kartlar;



}
