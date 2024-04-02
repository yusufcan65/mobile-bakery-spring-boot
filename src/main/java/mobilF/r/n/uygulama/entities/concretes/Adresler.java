package mobilF.r.n.uygulama.entities.concretes;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "Adresler")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Adresler {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "City")
    private String city;

    @Column(name = "District")
    private String district;

    @Column(name = "Number")
    private int number;

    @Column(name = "Street")
    private String street;

    @Column(name = "postcode")
    private String postcode;




    //ilişkiler buradadır
    @OneToMany(mappedBy = "adresler")//bunun işi bitti
    private List<Customer> customer;


    @OneToMany(mappedBy = "adresler")//bunun işi bitti
    private List<Bakery> bakery;



}
