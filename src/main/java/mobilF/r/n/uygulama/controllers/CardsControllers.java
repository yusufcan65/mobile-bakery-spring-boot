package mobilF.r.n.uygulama.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.CardsService;
import mobilF.r.n.uygulama.businness.requests.Cards.CreateCardsRequest;
import mobilF.r.n.uygulama.businness.requests.Cards.UpdateCardsRequest;
import mobilF.r.n.uygulama.businness.responses.Cards.GetAllCardsResponse;
import mobilF.r.n.uygulama.businness.responses.Cards.GetByIdCardsResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/cards")
@AllArgsConstructor
public class CardsControllers {

    private CardsService cardsService;

    @GetMapping
    List<GetAllCardsResponse> getAll(){
        return cardsService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdCardsResponse getById(@PathVariable int id){
        return cardsService.getById(id);
    }
    @PostMapping
    public void add(@RequestBody @Valid CreateCardsRequest createCardsRequest){
        this.cardsService.add(createCardsRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateCardsRequest updateCardsRequest){
        this.cardsService.update(updateCardsRequest);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){
        this.cardsService.delete(id);
    }
}
