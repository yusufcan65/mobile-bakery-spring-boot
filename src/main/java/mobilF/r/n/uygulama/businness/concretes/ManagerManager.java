package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.ManagerService;
import mobilF.r.n.uygulama.businness.requests.User.ManagerRequest;
import mobilF.r.n.uygulama.businness.responses.User.ManagerResponse;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.ManagerRepository;
import mobilF.r.n.uygulama.entities.concretes.Manager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ManagerManager implements ManagerService {

    private final ManagerRepository managerRepository;
    private final ModelMapperService modelMapperService;

    @Override
    public List<UserResponse> getAllManager() {

        List<Manager> managers= managerRepository.findAll();

        List<UserResponse> responses = managers.stream()
                .map(Manager->modelMapperService.forResponse()
                        .map(Manager, ManagerResponse.class)).collect(Collectors.toList());

        return responses;
    }

    @Override
    public void addManager(ManagerRequest managerRequest) {

        Manager manager = new Manager();

        manager.setName(managerRequest.getName());
        manager.setSurname(managerRequest.getSurname());
        manager.setUsername(managerRequest.getUsername());
        manager.setPassword(managerRequest.getPassword());
        this.managerRepository.save(manager);

    }

    @Override
    public void deleteManager(int id) {
        managerRepository.deleteById(id);
    }

    @Override
    public Optional<Manager> findByManagerId(int id) {

        return Optional.ofNullable(managerRepository.findById(id).orElseThrow(null));
    }
}
