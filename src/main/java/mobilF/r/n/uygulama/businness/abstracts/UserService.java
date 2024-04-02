package mobilF.r.n.uygulama.businness.abstracts;

import mobilF.r.n.uygulama.businness.requests.User.UserRequest;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;

import java.util.List;

public interface UserService {
    void addUser(String userType, UserRequest userRequest);

    List<UserResponse> getAll(String userType);

    void delete(String userType, int id);
}
