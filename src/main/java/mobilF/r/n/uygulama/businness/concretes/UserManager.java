package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.*;
import mobilF.r.n.uygulama.businness.requests.User.CustomerRequest;
import mobilF.r.n.uygulama.businness.requests.User.ManagerRequest;
import mobilF.r.n.uygulama.businness.requests.User.SellerRequest;
import mobilF.r.n.uygulama.businness.requests.User.UserRequest;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserManager implements UserService {

    private final CustomerService customerService;
    private final ManagerService managerService;
    private final SellerService sellerService;

    @Override
    public void addUser(String userType, UserRequest userRequest) {

        if("Customer".equalsIgnoreCase(userType)){
            this.customerService.addCustomer((CustomerRequest) userRequest);

        } else if ("Manager".equalsIgnoreCase(userType)) {

            this.managerService.addManager((ManagerRequest) userRequest);

        } else if ("Seller".equalsIgnoreCase(userType)) {

            this.sellerService.addSeller((SellerRequest) userRequest);

        }
        else {
            throw  new IllegalArgumentException("bu tipte User bulunamadı"+userType);
        }
    }

    @Override
    public List<UserResponse> getAll(String userType) {

        if("Customer".equalsIgnoreCase(userType)){

            return customerService.getAllCustomer();

        } else if ("Manager".equalsIgnoreCase(userType)) {

            return managerService.getAllManager();

        } else if ("Seller".equalsIgnoreCase(userType)) {

            return sellerService.getAllSeller();
        }
        else {
            throw new IllegalArgumentException("Invalid userType: " + userType);
        }
    }

    @Override
    public void delete(String userType, int id) {

        if("Customer".equalsIgnoreCase(userType)){
            this.customerService.deleteCustomer(id);
        } else if ("Manager".equalsIgnoreCase(userType)) {
            this.managerService.deleteManager(id);

        } else if ("Seller".equalsIgnoreCase(userType)) {
            this.sellerService.deleteSeller(id);
        }
        else {
            throw  new IllegalArgumentException("bu tipte User bulunamadı"+userType);
        }

    }
}
