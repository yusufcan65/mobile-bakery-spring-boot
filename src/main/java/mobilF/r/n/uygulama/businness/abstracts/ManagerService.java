package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.User.ManagerRequest;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;
import mobilF.r.n.uygulama.entities.concretes.Manager;

import java.util.List;
import java.util.Optional;

public interface ManagerService {

    List<UserResponse> getAllManager();

    void addManager(ManagerRequest managerRequest);
    void deleteManager(int id);

    Optional<Manager>  findByManagerId(int id);


}
