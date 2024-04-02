package mobilF.r.n.uygulama.dataAccess.abstarcts;

import mobilF.r.n.uygulama.entities.concretes.Adresler;
import mobilF.r.n.uygulama.entities.concretes.Bakery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BakeryRepository extends JpaRepository<Bakery,Integer> {
    Bakery findByName(String name);
    Boolean existsByName(String name);
}
