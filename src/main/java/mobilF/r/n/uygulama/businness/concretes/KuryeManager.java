package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.KuryeService;
import mobilF.r.n.uygulama.businness.requests.Kurye.CreateKuryeRequest;
import mobilF.r.n.uygulama.businness.responses.Kurye.GetAllKuryeResponse;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.KuryeRepository;
import mobilF.r.n.uygulama.entities.concretes.Kurye;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KuryeManager implements KuryeService {

    private final ModelMapperService modelMapperService;
    private final KuryeRepository kuryeRepository;

    @Override
    public List<GetAllKuryeResponse> getAll() {
        List<Kurye> kuryes = this.kuryeRepository.findAll();

        List<GetAllKuryeResponse> responses = kuryes.stream()
                .map(Kurye->modelMapperService.forResponse()
                        .map(Kurye, GetAllKuryeResponse.class)).collect(Collectors.toList());


        return responses;
    }

    @Override
    public void add(CreateKuryeRequest createKuryeRequest) {

        Kurye kurye = new Kurye();
        kurye.setName(createKuryeRequest.getName());
        kurye.setSurname(createKuryeRequest.getSurname());

        this.kuryeRepository.save(kurye);
    }

    @Override
    public void delete(int id) {

        this.kuryeRepository.deleteById(id);

    }

    @Override
    public Optional<Kurye> findByKuryeId(int id) {
        return Optional.ofNullable(kuryeRepository.findById(id).orElseThrow(null));
    }
}
