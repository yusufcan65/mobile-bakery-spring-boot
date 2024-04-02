package mobilF.r.n.uygulama.dataAccess.abstarcts;

import mobilF.r.n.uygulama.entities.concretes.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller,Integer> {
}
