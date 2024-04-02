package mobilF.r.n.uygulama.dataAccess.abstarcts;

import mobilF.r.n.uygulama.entities.concretes.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
}
