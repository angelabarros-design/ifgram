package Ifgram.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")

public class UserController {
    @GetMapping
    public String getUser () {
        return "chamei o endpoit como um GET!";

    }
    @PostMapping
    public String postUser () {
        return "chamei o endpoit como um POST!";
    }

    @DeleteMapping
    public String deleteUser () {
        return "chamei o endpoit como um DELETE!";
    }
}
