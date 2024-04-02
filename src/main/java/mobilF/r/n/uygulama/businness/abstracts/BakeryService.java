package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.Bakery.CreateBakeryRequest;
import mobilF.r.n.uygulama.businness.requests.Bakery.UpdateBakeryRequest;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetAllBakeryResponse;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetByIdBakeryResponse;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetByNameBakeryResponse;
import mobilF.r.n.uygulama.entities.concretes.Bakery;

import java.util.List;
import java.util.Optional;

public interface BakeryService {

    List<GetAllBakeryResponse> getAll();

    GetByIdBakeryResponse GetById(int id);

    GetByNameBakeryResponse GetByNameBakery(String name);

    void add(CreateBakeryRequest createBakeryRequest);

    void update(UpdateBakeryRequest updateBakeryRequest);

    void delete(int id);

    Optional<Bakery> FindByBakeryId(int id);
}
