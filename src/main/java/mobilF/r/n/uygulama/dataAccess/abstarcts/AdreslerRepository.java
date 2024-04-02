package mobilF.r.n.uygulama.dataAccess.abstarcts;

import mobilF.r.n.uygulama.entities.concretes.Adresler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdreslerRepository extends JpaRepository<Adresler,Integer> {

}
