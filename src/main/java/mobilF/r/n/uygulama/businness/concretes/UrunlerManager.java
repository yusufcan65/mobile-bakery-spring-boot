package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.BakeryService;
import mobilF.r.n.uygulama.businness.abstracts.UrunlerService;
import mobilF.r.n.uygulama.businness.requests.Urunler.CreateUrunlerRequest;
import mobilF.r.n.uygulama.businness.requests.Urunler.UpdateUrunlerRequest;
import mobilF.r.n.uygulama.businness.responses.Urunler.GetAllUrunlerResponse;
import mobilF.r.n.uygulama.businness.responses.Urunler.GetByIdUrunlerResponse;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.UrunlerRepository;
import mobilF.r.n.uygulama.entities.concretes.Bakery;
import mobilF.r.n.uygulama.entities.concretes.Urunler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UrunlerManager implements UrunlerService {

    private ModelMapperService modelMapperService;
    private UrunlerRepository urunlerRepository;
    private final BakeryService bakeryService;

    @Override
    public List<GetAllUrunlerResponse> getAll() {
        List<Urunler> urunler = this.urunlerRepository.findAll();

        List<GetAllUrunlerResponse> response = urunler.stream().
                map(Urunler-> modelMapperService.forResponse().
                        map(Urunler,GetAllUrunlerResponse.class)).collect(Collectors.toList());

        return response;
    }

    @Override
    public GetByIdUrunlerResponse getById(int id) {

        Urunler urunler = this.urunlerRepository.findById(id).orElseThrow();

        GetByIdUrunlerResponse response = this.modelMapperService.forResponse().
                map(urunler,GetByIdUrunlerResponse.class);


        return response;
    }

    @Override
    public void add(CreateUrunlerRequest createUrunlerRequest) {

        Bakery bakery= this.bakeryService.FindByBakeryId(createUrunlerRequest.getBakeryId()).orElseThrow(null);



        if(bakery!=null){
            Urunler urunler = new Urunler();

            urunler.setName(createUrunlerRequest.getName());
            urunler.setPrice(createUrunlerRequest.getPrice());

            bakery.getUrunler().add(urunler);
            urunler.setBakery(bakery);

            this.urunlerRepository.save(urunler);
        }

    }

    @Override
    public void update(UpdateUrunlerRequest updateUrunlerRequest) {
        Urunler urunler = this.modelMapperService.forRequest().map(updateUrunlerRequest,Urunler.class);

        this.urunlerRepository.save(urunler);
    }

    @Override
    public void delete(int id) {
        this.urunlerRepository.deleteById(id);
    }

    @Override
    public Optional<Urunler> findByUrunlerById(int id) {
        return Optional.ofNullable(urunlerRepository.findById(id).orElseThrow(null));
    }



}


       /* Urunler urunler = this.modelMapperService.forRequest().map(createUrunlerRequest,Urunler.class);

        this.urunlerRepository.save(urunler);*/

       /* Store store = storeRepository.findByUrunlerId(createUrunlerRequest.getStoreId()).orElseThrow(null);

        if(store != null){
            Urunler urunler = new Urunler();

            urunler.setName(createUrunlerRequest.getName());
            urunler.setPrice(createUrunlerRequest.getPrice());

            store.getUrunler().add(urunler);
            urunler.setStore(store);

            this.urunlerRepository.save(urunler);

        }*/




  /* int storeId = createUrunlerRequest.getStoreId();
        Store store = new Store();
        store.setId(storeId);

        urunler.setStore(store);*/



