package mobilF.r.n.uygulama.businness.concretes;


import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.AdreslerService;
import mobilF.r.n.uygulama.businness.abstracts.CustomerService;
import mobilF.r.n.uygulama.businness.requests.User.CustomerRequest;
import mobilF.r.n.uygulama.businness.responses.User.CustomerResponse;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.CustomerRepository;
import mobilF.r.n.uygulama.entities.concretes.Adresler;
import mobilF.r.n.uygulama.entities.concretes.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CustomerManager implements CustomerService {

    private final CustomerRepository customerRepository;
    private final ModelMapperService modelMapperService;
    private final AdreslerService adreslerService;

    @Override
    public void addCustomer(CustomerRequest customerRequest) {

        Adresler adresler = adreslerService.findByAdreslerId(customerRequest.getAdreslerId()).orElseThrow(null);

        Customer customer = new Customer();

        customer.setName(customerRequest.getName());
        customer.setSurname(customerRequest.getSurname());
        customer.setUsername(customerRequest.getUsername());
        customer.setPassword(customerRequest.getPassword());
        customer.setPhonenumber(customerRequest.getPhonenumber());
        customer.setEMail(customerRequest.getEMail());
        if(adresler != null){
            adresler.getCustomer().add(customer);
            customer.setAdresler(adresler);
        }

        this.customerRepository.save(customer);

  }
    @Override
    public List<UserResponse> getAllCustomer() {

        List<Customer> customers = customerRepository.findAll();
        List<UserResponse> customersResponse = customers.stream()
                .map(Customer -> this.modelMapperService.forResponse()
                        .map(Customer, CustomerResponse.class))
                .collect(Collectors.toList());
        return customersResponse;
    }
    @Override
    public void deleteCustomer(int id) {

        this.customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findByCustomerId(int id) {

        return Optional.ofNullable(customerRepository.findById(id).orElseThrow(null));
    }
}
