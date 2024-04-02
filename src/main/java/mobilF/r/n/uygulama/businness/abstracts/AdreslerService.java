package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.Adresler.CreateAdreslerRequest;
import mobilF.r.n.uygulama.businness.requests.Adresler.UpdateAdreslerRequest;
import mobilF.r.n.uygulama.businness.responses.Adresler.GetAllAdreslerResponse;
import mobilF.r.n.uygulama.businness.responses.Adresler.GetByIdAdreslerResponse;
import mobilF.r.n.uygulama.entities.concretes.Adresler;

import java.util.List;
import java.util.Optional;

public interface AdreslerService {

    List<GetAllAdreslerResponse> getAll();


    GetByIdAdreslerResponse GetById(int id);

    void add(CreateAdreslerRequest createAdreslerRequest);

    void update(UpdateAdreslerRequest updateAdreslerRequest);
    void delete(int id);

    Optional<Adresler> findByAdreslerId(int id);




}
