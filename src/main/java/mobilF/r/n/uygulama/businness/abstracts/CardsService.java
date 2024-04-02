package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.Cards.CreateCardsRequest;
import mobilF.r.n.uygulama.businness.requests.Cards.UpdateCardsRequest;
import mobilF.r.n.uygulama.businness.responses.Cards.GetAllCardsResponse;
import mobilF.r.n.uygulama.businness.responses.Cards.GetByIdCardsResponse;
import mobilF.r.n.uygulama.entities.concretes.Kartlar;

import java.util.List;
import java.util.Optional;

public interface CardsService {

    List<GetAllCardsResponse> getAll();

    GetByIdCardsResponse getById(int id);

    void add(CreateCardsRequest createCardsRequest);

    void update(UpdateCardsRequest updateCardsRequest);

    void delete(int id);

    Optional<Kartlar> findByKartlarId(int id);

}
