package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.CustomerService;
import mobilF.r.n.uygulama.businness.abstracts.KampanyaService;
import mobilF.r.n.uygulama.businness.abstracts.ManagerService;
import mobilF.r.n.uygulama.businness.requests.Kampanya.CreateKampanyaRequest;
import mobilF.r.n.uygulama.businness.requests.Kampanya.UpdateKampanyaRequest;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetAllKampanyaResponse;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetByIdKampanyaResponse;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetByKampanyaNameResponse;
import mobilF.r.n.uygulama.businness.rules.KampanyalarBusinnessRules;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.KampanyaRepository;
import mobilF.r.n.uygulama.entities.concretes.Customer;
import mobilF.r.n.uygulama.entities.concretes.Kampanyalar;
import mobilF.r.n.uygulama.entities.concretes.Manager;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class KampanyaManager implements KampanyaService {

    private final ModelMapperService modelMapperService;
    private final KampanyaRepository kampanyaRepository;
    private final CustomerService customerService;
    private final ManagerService managerService;
    private final KampanyalarBusinnessRules kampanyalarBusinnessRules;

    @Override
    public List<GetAllKampanyaResponse> getAll() {
        List<Kampanyalar> kampanyalar = this.kampanyaRepository.findAll();

        List<GetAllKampanyaResponse> response = kampanyalar.stream()
                .map(Kampanyalar-> this.modelMapperService.forResponse()
                        .map(Kampanyalar,GetAllKampanyaResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public GetByIdKampanyaResponse getById(int id) {
        Kampanyalar kampanyalar = this.kampanyaRepository.findById(id).orElseThrow();

        GetByIdKampanyaResponse response= this.modelMapperService.forResponse().map(kampanyalar,GetByIdKampanyaResponse.class);

        return response;
    }

    @Override
    public void add(CreateKampanyaRequest createKampanyaRequest) {

        Customer customer = this.customerService.findByCustomerId(createKampanyaRequest.getCustomerId()).orElseThrow(null);
        Manager manager = this.managerService.findByManagerId(createKampanyaRequest.getManagerId()).orElseThrow(null);

        Kampanyalar kampanyalar= new Kampanyalar();

        if(customer != null){
            customer.getKampanyalar().add(kampanyalar);
            kampanyalar.setCustomer(customer);
        }
        if(manager != null){
            manager.getKampanyalar().add(kampanyalar);
            kampanyalar.setManager(manager);
        }

        kampanyalar.setName(createKampanyaRequest.getName());
        kampanyalar.setExpirydate(createKampanyaRequest.getExpirydate());

        this.kampanyaRepository.save(kampanyalar);

    }

    @Override
    public void update(UpdateKampanyaRequest updateKampanyaRequest) {
        Kampanyalar kampanyalar = this.modelMapperService.forRequest().map(updateKampanyaRequest,Kampanyalar.class);
        this.kampanyaRepository.save(kampanyalar);
    }

    @Override
    public void delete(int id) {
        this.kampanyaRepository.deleteById(id);
    }

    @Override
    public GetByKampanyaNameResponse getByKampanyaName(String name) {
        this.kampanyalarBusinnessRules.CheckIfKampanyaName(name);

        Kampanyalar kampanyalar = this.kampanyaRepository.findByName(name);
        GetByKampanyaNameResponse response = this.modelMapperService.forResponse().map(kampanyalar,GetByKampanyaNameResponse.class);

        return  response;
    }

    @Override
    public Optional<Kampanyalar> findByKampanyalarId(int id) {

        return Optional.ofNullable(kampanyaRepository.findById(id).orElse(null));
    }
}







