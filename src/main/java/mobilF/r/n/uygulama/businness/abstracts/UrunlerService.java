package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.Urunler.CreateUrunlerRequest;
import mobilF.r.n.uygulama.businness.requests.Urunler.UpdateUrunlerRequest;
import mobilF.r.n.uygulama.businness.responses.Urunler.GetAllUrunlerResponse;
import mobilF.r.n.uygulama.businness.responses.Urunler.GetByIdUrunlerResponse;
import mobilF.r.n.uygulama.entities.concretes.Urunler;

import java.util.List;
import java.util.Optional;

public interface UrunlerService {

    List<GetAllUrunlerResponse> getAll();
    GetByIdUrunlerResponse getById(int id);
    void add(CreateUrunlerRequest createUrunlerRequest);
    void update(UpdateUrunlerRequest updateUrunlerRequest);
    void delete(int id);

    Optional<Urunler> findByUrunlerById(int id);

}
