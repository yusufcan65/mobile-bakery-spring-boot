package mobilF.r.n.uygulama.businness.rules;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.core.utilities.exceptions.BusinessException;
import mobilF.r.n.uygulama.dataAccess.abstarcts.BakeryRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BakeryBusinnessRules {

    private final BakeryRepository bakeryRepository;

    public void checkIfBakeryNameExists(String name){
        if(this.bakeryRepository.existsByName(name)){
            throw new BusinessException("Bakery name already exists");
        }
    }
    public Boolean CheckIfBakeryNameControl(String name){
        if(this.bakeryRepository.existsByName(name)){
            return  true;
        }
        else{
            throw new BusinessException("Bakery name not found");
        }
    }
}
