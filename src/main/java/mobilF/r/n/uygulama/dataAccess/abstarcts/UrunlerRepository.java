package mobilF.r.n.uygulama.dataAccess.abstarcts;

import mobilF.r.n.uygulama.entities.concretes.Urunler;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrunlerRepository extends JpaRepository<Urunler,Integer> {



   // Optional<Urunler> findBySiparişId(Integer siaprişId);

}
