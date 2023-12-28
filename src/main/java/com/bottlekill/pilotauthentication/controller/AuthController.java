package com.bottlekill.pilotauthentication.controller;

import com.bottlekill.pilotauthentication.config.securiy.oauth.PrincipalDetails;
import com.bottlekill.pilotauthentication.controller.repository.UserRepository;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

//    private UserRepository userRepository;

    @PostMapping("/user")
    public @ResponseBody String user(@AuthenticationPrincipal PrincipalDetails principalDetails){
        return "로그인한 회원이 접속 가능";
    }
    @PostMapping("/login")
    public String login() {
        return "success";
    }
    @PostMapping("/admin")
    public String adminLogin() {
        return "success";
    }
    @PostMapping("/oauth2/authorization/google") // 고정된 주소
    public String googleLogin() {return "googleLoginSuccess";}

//    public UserRepository getUserRepository() {
//        return userRepository;
//    }
}