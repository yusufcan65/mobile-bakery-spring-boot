package mobilF.r.n.uygulama.dataAccess.abstarcts;

import mobilF.r.n.uygulama.entities.concretes.Kartlar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsRepository extends JpaRepository<Kartlar,Integer> {


}
