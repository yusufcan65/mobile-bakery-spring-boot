package mobilF.r.n.uygulama.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.UrunlerService;
import mobilF.r.n.uygulama.businness.requests.Urunler.CreateUrunlerRequest;
import mobilF.r.n.uygulama.businness.requests.Urunler.UpdateUrunlerRequest;
import mobilF.r.n.uygulama.businness.responses.Urunler.GetAllUrunlerResponse;
import mobilF.r.n.uygulama.businness.responses.Urunler.GetByIdUrunlerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/urunler")
@AllArgsConstructor
public class UrunlerControllers {

    private UrunlerService urunlerService;

    @GetMapping
    List<GetAllUrunlerResponse> getall(){
        return urunlerService.getAll();
    }

    @GetMapping("/{id}")
    GetByIdUrunlerResponse getById(@PathVariable int id){
        return urunlerService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateUrunlerRequest createUrunlerRequest){
        this.urunlerService.add(createUrunlerRequest);
    }

    @PutMapping
    public void update(@RequestBody UpdateUrunlerRequest updateUrunlerRequest){
        this.urunlerService.update(updateUrunlerRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.urunlerService.delete(id);
    }
}
