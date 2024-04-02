package mobilF.r.n.uygulama.businness.rules;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.core.utilities.exceptions.BusinessException;
import mobilF.r.n.uygulama.dataAccess.abstarcts.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerBusinnessRules {

    private CustomerRepository customerRepository;

    public void checkIfCustomerNameExists(String name){
        if(this.customerRepository.existsByName(name)){
            throw new BusinessException("Customer name already exists");
        }
    }

}
