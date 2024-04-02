package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.AdreslerService;
import mobilF.r.n.uygulama.businness.requests.Adresler.CreateAdreslerRequest;
import mobilF.r.n.uygulama.businness.requests.Adresler.UpdateAdreslerRequest;
import mobilF.r.n.uygulama.businness.responses.Adresler.GetAllAdreslerResponse;
import mobilF.r.n.uygulama.businness.responses.Adresler.GetByIdAdreslerResponse;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.AdreslerRepository;
import mobilF.r.n.uygulama.entities.concretes.Adresler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@AllArgsConstructor
public class AdreslerManager implements AdreslerService {

    private AdreslerRepository adreslerRepository;
    private ModelMapperService modelMapperService;

    @Override
    public List<GetAllAdreslerResponse> getAll() {

        List<Adresler> adresler = adreslerRepository.findAll();
        List<GetAllAdreslerResponse> adreslerResponse = adresler.stream()
                .map(Adresler -> this.modelMapperService.forResponse()
                        .map(Adresler, GetAllAdreslerResponse.class))
                                .collect(Collectors.toList());

        return adreslerResponse;
    }
    @Override
    public GetByIdAdreslerResponse GetById(int id) {
        Adresler adresler = this.adreslerRepository.findById(id).orElseThrow();

        GetByIdAdreslerResponse response = this.modelMapperService.forResponse().
                map(adresler,GetByIdAdreslerResponse.class);

        return response;
    }
    @Override
    public void add(CreateAdreslerRequest createAdreslerRequest) {

        Adresler adresler = this.modelMapperService.forRequest().map(createAdreslerRequest,Adresler.class);

        this.adreslerRepository.save(adresler);
    }
    @Override
    public void update(UpdateAdreslerRequest updateAdreslerRequest) {

        Adresler adresler = this.modelMapperService.forRequest().map(updateAdreslerRequest,Adresler.class);

        this.adreslerRepository.save(adresler);

    }

    @Override
    public void delete(int id) {

        this.adreslerRepository.deleteById(id);
    }

    @Override
    public Optional<Adresler> findByAdreslerId(int id) {
        return Optional.ofNullable(adreslerRepository.findById(id).orElseThrow(null));
    }


}
