package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.User.CustomerRequest;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;
import mobilF.r.n.uygulama.entities.concretes.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {



    List<UserResponse> getAllCustomer();
    void addCustomer(CustomerRequest customerRequest);
    void deleteCustomer(int id);

    Optional<Customer> findByCustomerId(int id);
}
