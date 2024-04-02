package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.CardsService;
import mobilF.r.n.uygulama.businness.abstracts.CustomerService;
import mobilF.r.n.uygulama.businness.requests.Cards.CreateCardsRequest;
import mobilF.r.n.uygulama.businness.requests.Cards.UpdateCardsRequest;
import mobilF.r.n.uygulama.businness.responses.Cards.GetAllCardsResponse;
import mobilF.r.n.uygulama.businness.responses.Cards.GetByIdCardsResponse;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.CardsRepository;
import mobilF.r.n.uygulama.entities.concretes.Customer;
import mobilF.r.n.uygulama.entities.concretes.Kartlar;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CardsManager implements CardsService {

    private final ModelMapperService modelMapperService;
    private final CardsRepository cardsRepository;
    private final CustomerService customerService;


    @Override
    public List<GetAllCardsResponse> getAll() {
        List<Kartlar> kartlar= this.cardsRepository.findAll();

        List<GetAllCardsResponse> response = kartlar.stream()
                .map(Kartlar-> this.modelMapperService.forResponse()
                        .map(Kartlar,GetAllCardsResponse.class))
                            .collect(Collectors.toList());
        return response;
    }

    @Override
    public GetByIdCardsResponse getById(int id) {

        Kartlar kartlar = this.cardsRepository.findById(id).orElseThrow();

        GetByIdCardsResponse response = modelMapperService.forResponse()
                .map(kartlar,GetByIdCardsResponse.class);

        return response;
    }


    @Override
    public void add(CreateCardsRequest createCardsRequest) {
        Customer customer = this.customerService.findByCustomerId(createCardsRequest.getCustomerId()).orElseThrow(null);

        Kartlar kartlar = new Kartlar();



        if(customer != null){
            customer.getKartlar().add(kartlar);
            kartlar.setCustomer(customer);
        }

        kartlar.setCartname(createCardsRequest.getCartname());
        kartlar.setCvc(Integer.parseInt(createCardsRequest.getCvc()));
        kartlar.setCartno(createCardsRequest.getCartno());
        kartlar.setExpirydate(createCardsRequest.getExpirydate());
        kartlar.setKartlimit( createCardsRequest.getKartlimit());

        cardsRepository.save(kartlar);

    }

    @Override
    public void update(UpdateCardsRequest updateCardsRequest) {

        Kartlar kartlar = this.modelMapperService.forRequest().map(updateCardsRequest,Kartlar.class);

        this.cardsRepository.save(kartlar);

    }

    @Override
    public void delete(int id) {

        this.cardsRepository.deleteById(id);

    }

    @Override
    public Optional<Kartlar> findByKartlarId(int id) {

        return Optional.ofNullable(cardsRepository.findById(id).orElseThrow(null));
    }

}