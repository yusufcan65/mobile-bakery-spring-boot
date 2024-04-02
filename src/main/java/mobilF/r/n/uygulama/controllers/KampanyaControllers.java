package mobilF.r.n.uygulama.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.KampanyaService;
import mobilF.r.n.uygulama.businness.requests.Kampanya.CreateKampanyaRequest;
import mobilF.r.n.uygulama.businness.requests.Kampanya.UpdateKampanyaRequest;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetAllKampanyaResponse;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetByIdKampanyaResponse;
import mobilF.r.n.uygulama.businness.responses.Kampanya.GetByKampanyaNameResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kampanyalar")
@AllArgsConstructor
public class KampanyaControllers {

    private KampanyaService kampanyaService;

    @GetMapping
    List<GetAllKampanyaResponse> getall(){
        return kampanyaService.getAll();
    }

    @GetMapping("/id/{id}")
    GetByIdKampanyaResponse getById(@PathVariable int id){
        return kampanyaService.getById(id);
    }

    @GetMapping("/name/{name}")
    GetByKampanyaNameResponse getByName(@PathVariable String name){
        return kampanyaService.getByKampanyaName(name);
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateKampanyaRequest createKampanyaRequest){
        this.kampanyaService.add(createKampanyaRequest);
    }


    @PutMapping
    public void update(@RequestBody UpdateKampanyaRequest updateKampanyaRequest){
        this.kampanyaService.update(updateKampanyaRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(int id){
        this.kampanyaService.delete(id);
    }




}
