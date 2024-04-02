package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.User.SellerRequest;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;

import java.util.List;

public interface SellerService {

    List<UserResponse> getAllSeller();
    void addSeller(SellerRequest sellerRequest);
    void deleteSeller(int id);
}
