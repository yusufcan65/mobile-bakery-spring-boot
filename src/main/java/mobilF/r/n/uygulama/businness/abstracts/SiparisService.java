package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.Siparis.CreateSiparisRequest;
import mobilF.r.n.uygulama.businness.requests.Siparis.UpdateSiparisRequest;
import mobilF.r.n.uygulama.businness.responses.Siparis.GetAllSiparisResponse;
import mobilF.r.n.uygulama.businness.responses.Siparis.GetByIdSiparisResponse;

import java.util.List;

public interface SiparisService {

    List<GetAllSiparisResponse> getAll();

    GetByIdSiparisResponse getById(int id);

    void add(CreateSiparisRequest createSiparisRequest);

    void update(UpdateSiparisRequest updateSiparisRequest);

    void delete(int id);


}
