package spring.security.async.authentication.fetch.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FetchController {
    @PostMapping("/fetch/login")
    public String fetchLogin(){
        return "fetch/login";
    }
}
