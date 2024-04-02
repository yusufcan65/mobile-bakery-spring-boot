package mobilF.r.n.uygulama.controllers;

import lombok.AllArgsConstructor;
import mobilF.r.n.uygulama.businness.abstracts.UserService;
import mobilF.r.n.uygulama.businness.requests.User.UserRequest;
import mobilF.r.n.uygulama.businness.responses.User.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/user")
@AllArgsConstructor

public class UserController {


    private UserService userService;



    @PostMapping("/{userType}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void add(@PathVariable String userType,@RequestBody UserRequest userRequest){

        userService.addUser(userType,userRequest);
    }
    @GetMapping("/{userType}")
    public List<UserResponse> getall(@PathVariable String userType){

        return userService.getAll(userType);
    }


    @DeleteMapping("/{userType}/{id}")
    public void delete(@PathVariable  String userType, @PathVariable int id){
        userService.delete(userType,id);
    }


}
