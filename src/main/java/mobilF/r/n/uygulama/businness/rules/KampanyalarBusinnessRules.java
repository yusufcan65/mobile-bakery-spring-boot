package mobilF.r.n.uygulama.businness.rules;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.core.utilities.exceptions.BusinessException;
import mobilF.r.n.uygulama.dataAccess.abstarcts.KampanyaRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KampanyalarBusinnessRules {
    private final KampanyaRepository kampanyaRepository;

    public boolean CheckIfKampanyaName(String name){
        if(this.kampanyaRepository.existsByName(name)){
            return  true;
        }
        else{
            throw new BusinessException("kampanya name not found");
        }
    }


}
