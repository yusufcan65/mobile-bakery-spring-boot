package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.Kurye.CreateKuryeRequest;
import mobilF.r.n.uygulama.businness.responses.Kurye.GetAllKuryeResponse;
import mobilF.r.n.uygulama.entities.concretes.Kurye;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface KuryeService {

    List<GetAllKuryeResponse> getAll();
    void add(CreateKuryeRequest createKuryeRequest);
    void delete(int id);

    Optional<Kurye> findByKuryeId(int id);





}
