package Ifgram.controller;

import Ifgram.Model.User;
import Ifgram.dto.UserRequest;
import Ifgram.dto.UserResponse;
import Ifgram.service.UserService;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {
    
    private final UserService service;
    
    public UserController(UserService service){
        this.service = service;
    }

    @GetMapping
    public String getUser () {
        return "chamei o endpoit como um GET!";

    }
    @PostMapping
    public String postUser () {
        return "chamei o endpoit como um POST!";
    }

    @PutMapping 
    public UserResponse putUser(UserRequest request) throws Exception {
        UserResponse userResponse;
        userResponse = service.atualizarUsuario(request);
        return userResponse;
    }
    
    
    @DeleteMapping
    public String deleteUser () {
        return "chamei o endpoit como um DELETE!";
    }
}
