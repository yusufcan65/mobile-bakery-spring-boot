package mobilF.r.n.uygulama.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.BakeryService;
import mobilF.r.n.uygulama.businness.requests.Bakery.CreateBakeryRequest;
import mobilF.r.n.uygulama.businness.requests.Bakery.UpdateBakeryRequest;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetAllBakeryResponse;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetByIdBakeryResponse;
import mobilF.r.n.uygulama.businness.responses.Bakery.GetByNameBakeryResponse;
import mobilF.r.n.uygulama.core.utilities.exceptions.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/bakery")
@RestController
@AllArgsConstructor
public class BakeryControllers {
    private BakeryService bakeryService;

    @GetMapping()
    List<GetAllBakeryResponse> getAll(){

        return bakeryService.getAll();
    }
    @GetMapping("/id/{id}")
    GetByIdBakeryResponse getById(@PathVariable int id){
        return bakeryService.GetById(id);
    }

    @GetMapping( "/name/{name}")

    GetByNameBakeryResponse getByName(@PathVariable String name){
       return bakeryService.GetByNameBakery(name);

    }


    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add( @RequestBody @Valid CreateBakeryRequest createBakeryRequest){
        this.bakeryService.add(createBakeryRequest);
    }

    @PutMapping()
    public void update(@RequestBody UpdateBakeryRequest updateBakeryRequest){
        this.bakeryService.update(updateBakeryRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable  int id){

        this.bakeryService.delete(id);
    }


}
