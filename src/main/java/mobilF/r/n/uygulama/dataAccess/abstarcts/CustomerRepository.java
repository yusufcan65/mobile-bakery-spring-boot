package mobilF.r.n.uygulama.dataAccess.abstarcts;

import mobilF.r.n.uygulama.entities.concretes.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository  extends JpaRepository<Customer,Integer> {

    boolean existsByName(String name);

 //   Optional<Customer> findBySiparişId(Integer siparişId);

   /* Optional<Customer> findByKartlarId(Integer kartlarId);

    Optional<Customer> findByKampanyalarId(Integer kampanyalarId);*/




}
