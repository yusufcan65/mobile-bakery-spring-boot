package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.*;
import mobilF.r.n.uygulama.businness.requests.Siparis.CreateSiparisRequest;
import mobilF.r.n.uygulama.businness.requests.Siparis.UpdateSiparisRequest;
import mobilF.r.n.uygulama.businness.responses.Siparis.GetAllSiparisResponse;
import mobilF.r.n.uygulama.businness.responses.Siparis.GetByIdSiparisResponse;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.SiparisRepository;
import mobilF.r.n.uygulama.entities.concretes.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SiparisManager implements SiparisService {

    private final ModelMapperService modelMapperService;
    private final SiparisRepository siparisRepository;
    private final UrunlerService urunlerService;
    private final CardsService cardsService;
    private final KampanyaService kampanyaService;
    private final CustomerService customerService;
    private final KuryeService kuryeService;


    @Override
    public List<GetAllSiparisResponse> getAll() {
        List<Siparis> siparis = siparisRepository.findAll();
        List<GetAllSiparisResponse> siparisResponse = siparis.stream()
                .map(Siparis-> this.modelMapperService.forResponse()
                        .map(Siparis, GetAllSiparisResponse.class)).collect(Collectors.toList());

        return siparisResponse;
    }

    @Override
    public GetByIdSiparisResponse getById(int id) {

        Siparis siparis = this.siparisRepository.findById(id).orElseThrow();

        GetByIdSiparisResponse siparisResponse = this.modelMapperService.forResponse()
                .map(siparis,GetByIdSiparisResponse.class);
        return siparisResponse;
    }

    @Override
    public void add(CreateSiparisRequest createSiparisRequest) {
        Urunler urunler = this.urunlerService.findByUrunlerById(createSiparisRequest.getUrunlerId()).orElseThrow(null);
        Kartlar kartlar = this.cardsService.findByKartlarId(createSiparisRequest.getKartlarId()).orElseThrow(null);
        Customer customer = this.customerService.findByCustomerId(createSiparisRequest.getCustomerId()).orElseThrow(null);
        Kampanyalar kampanyalar = this.kampanyaService.findByKampanyalarId(createSiparisRequest.getKampanyalarId()).orElseThrow(null);
        Kurye kurye = this.kuryeService.findByKuryeId(createSiparisRequest.getKuryeId()).orElseThrow(null);


        Siparis siparis= new Siparis();


        if(kurye != null){
            kurye.getSiparis().add(siparis);
            siparis.setKurye(kurye);
        }

        if( customer != null ){
            customer.getSiparis().add(siparis);
            siparis.setCustomer(customer);
        }
        if(kampanyalar != null){
            kampanyalar.getSiparis().add(siparis);
            siparis.setKampanyalar(kampanyalar);
        }
        if(kartlar != null){
            kartlar.getSiparis().add(siparis);
            siparis.setKartlar(kartlar);
        }
        if(urunler != null){
            urunler.getSiparis().add(siparis);
            siparis.setUrunler(urunler);
        }

        siparis.setUrunsayısı(createSiparisRequest.getUrunsayısı());
        siparis.setAmount(siparis.getUrunsayısı()*urunler.getPrice());


        if(kartlar.getKartlimit() < siparis.getAmount()){
            throw new IllegalArgumentException(kartlar.getCustomer().getName() +" isimli kullanıcının kart limiti yetersiz ");
        }
        else{
          kartlar.setKartlimit(kartlar.getKartlimit()-siparis.getAmount());
        }


        this.siparisRepository.save(siparis);


    }

    @Override
    public void update(UpdateSiparisRequest updateSiparisRequest) {

        Siparis siparis= this.modelMapperService.forRequest().map(updateSiparisRequest,Siparis.class);

        this.siparisRepository.save(siparis);

    }

    @Override
    public void delete(int id) {
        this.siparisRepository.deleteById(id);
    }
}




