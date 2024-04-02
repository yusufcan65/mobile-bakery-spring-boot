package mobilF.r.n.uygulama.businness.concretes;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.BakeryService;
import mobilF.r.n.uygulama.businness.abstracts.SellerService;
import mobilF.r.n.uygulama.businness.requests.User.SellerRequest;
import mobilF.r.n.uygulama.businness.responses.User.SellerResponse;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;
import mobilF.r.n.uygulama.core.utilities.mappers.ModelMapperService;
import mobilF.r.n.uygulama.dataAccess.abstarcts.SellerRepository;
import mobilF.r.n.uygulama.entities.concretes.Bakery;
import mobilF.r.n.uygulama.entities.concretes.Seller;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SellerManager implements SellerService {

    private final SellerRepository sellerRepository;
    private final ModelMapperService modelMapperService;
    private final BakeryService bakeryService;

    @Override
    public List<UserResponse> getAllSeller() {

        List<Seller>  sellers = sellerRepository.findAll();

        List<UserResponse> responses = sellers.stream().
                map(Seller->modelMapperService.forResponse().
                        map(Seller, SellerResponse.class)).collect(Collectors.toList());


        return responses;
    }

    @Override
    public void addSeller(SellerRequest sellerRequest) {

        Bakery bakery = this.bakeryService.FindByBakeryId(sellerRequest.getBakeryId()).orElseThrow(null);
        Seller seller = new Seller();
        seller.setName(sellerRequest.getName());
        seller.setSurname(sellerRequest.getSurname());
        seller.setUsername(sellerRequest.getUsername());
        seller.setPassword(sellerRequest.getPassword());
        seller.setEMail(sellerRequest.getEMail());

        seller.setBakery(bakery);
        this.sellerRepository.save(seller);
    }

    @Override
    public void deleteSeller(int id) {
        sellerRepository.deleteById(id);
    }
}
