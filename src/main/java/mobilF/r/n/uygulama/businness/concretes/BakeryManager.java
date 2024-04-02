package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.AdreslerService;
import mobilF.r.n.uygulama.businness.abstracts.BakeryService;
import mobilF.r.n.uygulama.businness.requests.Bakery.CreateBakeryRequest;
import mobilF.r.n.uygulama.businness.requests.Bakery.UpdateBakeryRequest;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetAllBakeryResponse;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetByIdBakeryResponse;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetByNameBakeryResponse;
import mobilF.r.n.uygulama.businness.rules.BakeryBusinnessRules;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.BakeryRepository;
import mobilF.r.n.uygulama.entities.concretes.Adresler;
import mobilF.r.n.uygulama.entities.concretes.Bakery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class BakeryManager implements BakeryService {

    private final ModelMapperService modelMapperService;
    private final BakeryBusinnessRules bakeryBusinnessRules;
    private final BakeryRepository bakeryRepository;
    private final AdreslerService adreslerService;



    @Override
    public List<GetAllBakeryResponse> getAll() {
        List<Bakery> bakery = bakeryRepository.findAll();

        List<GetAllBakeryResponse> bakeryResponse = bakery.stream()
                .map(Bakery-> this.modelMapperService.forResponse()
                        .map(Bakery, GetAllBakeryResponse.class)).
                            collect(Collectors.toList());
        return bakeryResponse;
    }

    @Override
    public GetByIdBakeryResponse GetById(int id) {

        Bakery bakery = this.bakeryRepository.findById(id).orElseThrow();

        GetByIdBakeryResponse response = this.modelMapperService.forResponse()
                .map(bakery, GetByIdBakeryResponse.class);

        return response;
    }

    @Override
    public GetByNameBakeryResponse GetByNameBakery(String name) {
        this.bakeryBusinnessRules.CheckIfBakeryNameControl(name);

        Bakery bakery = this.bakeryRepository.findByName(name);
        GetByNameBakeryResponse response = this.modelMapperService.forResponse().map(bakery, GetByNameBakeryResponse.class);

        return response;
    }

    @Override
    public void add(CreateBakeryRequest createBakeryRequest) {
        Adresler adresler = adreslerService.findByAdreslerId(createBakeryRequest.getAdreslerId()).orElseThrow(null);

        this.bakeryBusinnessRules.checkIfBakeryNameExists(createBakeryRequest.getName());
        Bakery bakery = new Bakery();
        if(adresler != null){
            adresler.getBakery().add(bakery);
            bakery.setAdresler(adresler);
        }

        bakery.setName(createBakeryRequest.getName());
        bakery.setPhoneNumber(createBakeryRequest.getPhoneNumber());



        this.bakeryRepository.save(bakery);

    }

    @Override
    public void update(UpdateBakeryRequest updateBakeryRequest) {
        Bakery bakery = this.modelMapperService.forRequest().map(updateBakeryRequest,Bakery.class);

        this.bakeryRepository.save(bakery);
    }

    @Override
    public void delete(int id) {

        this.bakeryRepository.deleteById(id);

    }

    @Override
    public Optional<Bakery> FindByBakeryId(int id) {
        return Optional.ofNullable(bakeryRepository.findById(id).orElseThrow(null));
    }
}
