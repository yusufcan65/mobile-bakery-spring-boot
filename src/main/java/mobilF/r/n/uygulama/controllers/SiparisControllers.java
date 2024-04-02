package mobilF.r.n.uygulama.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.SiparisService;
import mobilF.r.n.uygulama.businness.requests.Siparis.CreateSiparisRequest;
import mobilF.r.n.uygulama.businness.requests.Siparis.UpdateSiparisRequest;
import mobilF.r.n.uygulama.businness.responses.Siparis.GetAllSiparisResponse;
import mobilF.r.n.uygulama.businness.responses.Siparis.GetByIdSiparisResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/siparis")
@AllArgsConstructor
public class SiparisControllers {

    private SiparisService siparisService;


    @GetMapping
    List<GetAllSiparisResponse> getAll(){
        return siparisService.getAll();
    }
    @GetMapping("/{id}")
    public GetByIdSiparisResponse getById(@PathVariable() int id){
        return siparisService.getById(id);
    }

    @PostMapping()
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@RequestBody() @Valid CreateSiparisRequest createSiparisRequest){
        this.siparisService.add(createSiparisRequest);
    }

    @PutMapping()
    public void update(@RequestBody() UpdateSiparisRequest updateSiparisRequest){
        this.siparisService.update(updateSiparisRequest);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable() int id){
        this.siparisService.delete(id);
    }





}
