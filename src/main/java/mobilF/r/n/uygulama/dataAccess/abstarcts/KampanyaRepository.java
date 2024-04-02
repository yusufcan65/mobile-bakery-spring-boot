package mobilF.r.n.uygulama.dataAccess.abstarcts;

import mobilF.r.n.uygulama.entities.concretes.Bakery;
import mobilF.r.n.uygulama.entities.concretes.Kampanyalar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KampanyaRepository extends JpaRepository<Kampanyalar, Integer> {

    Boolean existsByName(String name);

    Kampanyalar findByName(String name);

}
