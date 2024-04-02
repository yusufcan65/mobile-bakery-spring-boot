package mobilF.r.n.uygulama.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.AdreslerService;
import mobilF.r.n.uygulama.businness.requests.Adresler.CreateAdreslerRequest;
import mobilF.r.n.uygulama.businness.requests.Adresler.UpdateAdreslerRequest;
import mobilF.r.n.uygulama.businness.responses.Adresler.GetAllAdreslerResponse;
import mobilF.r.n.uygulama.businness.responses.Adresler.GetByIdAdreslerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/adresler")
@AllArgsConstructor

public class AdreslerControllers {
    AdreslerService adreslerService;

    @GetMapping()
    List<GetAllAdreslerResponse> getAll( ){
        return adreslerService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdAdreslerResponse getById(@PathVariable int id){
        return adreslerService.GetById(id);
    }
    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid() CreateAdreslerRequest createAdreslerRequest){
        this.adreslerService.add(createAdreslerRequest);
    }
    @PutMapping()
    public void update(@RequestBody UpdateAdreslerRequest updateAdreslerRequest){
        this.adreslerService.update(updateAdreslerRequest);
    }

    @DeleteMapping("/{id}")
    public void delete( @PathVariable int id){
        this.adreslerService.delete(id);
    }

   /* @PutMapping("/{city}")
    public void cityUpdate(@RequestBody UpdateCityRequest updateCityRequest){
       this.adreslerService.cityUpdate(updateCityRequest);
    }*/



}