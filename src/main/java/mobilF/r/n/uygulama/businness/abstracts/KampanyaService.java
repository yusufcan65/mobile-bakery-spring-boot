package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.Kampanya.CreateKampanyaRequest;
import mobilF.r.n.uygulama.businness.requests.Kampanya.UpdateKampanyaRequest;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetAllKampanyaResponse;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetByIdKampanyaResponse;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetByKampanyaNameResponse;
import mobilF.r.n.uygulama.entities.concretes.Kampanyalar;

import java.util.List;
import java.util.Optional;

public interface KampanyaService {
    List<GetAllKampanyaResponse> getAll();
    GetByIdKampanyaResponse getById(int id);
    void add(CreateKampanyaRequest createKampanyaRequest);
    void update(UpdateKampanyaRequest updateKampanyaRequest);
    void delete(int id);

    GetByKampanyaNameResponse getByKampanyaName(String name);

    Optional<Kampanyalar> findByKampanyalarId(int id);


}
