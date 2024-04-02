package mobilF.r.n.uygulama.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.KuryeService;
import mobilF.r.n.uygulama.businness.requests.Kurye.CreateKuryeRequest;
import mobilF.r.n.uygulama.businness.responses.Kurye.GetAllKuryeResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kurye")
@AllArgsConstructor
public class KuryeControllers {

    private final KuryeService kuryeService;

    @GetMapping
    List<GetAllKuryeResponse > getall(){
        return kuryeService.getAll();
    }

    @PostMapping
    @ResponseStatus(code=HttpStatus.CREATED)
    public void add(@RequestBody @Valid CreateKuryeRequest createKuryeRequest){
        this.kuryeService.add(createKuryeRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        this.kuryeService.delete(id);
    }

}
