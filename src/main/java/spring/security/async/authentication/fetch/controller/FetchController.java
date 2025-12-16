package spring.security.async.authentication.fetch.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.security.async.authentication.auth.users.domain.vo.UserInfomation;

@RestController
public class FetchController {
    @PostMapping("/fetch/login")
    public String fetchLogin(){
        return "fetch/login";
    }

    @GetMapping("/fetch/user")
    public UserInfomation fetchUser(@AuthenticationPrincipal UserInfomation userInfomation){
        return userInfomation;
    }

    @GetMapping("/fetch/manager")
    public UserInfomation fetchManager(@AuthenticationPrincipal UserInfomation userInfomation){
        return userInfomation;
    }

    @GetMapping("/fetch/admin")
    public UserInfomation fetchAdmin(@AuthenticationPrincipal UserInfomation userInfomation){
        return userInfomation;
    }
}
