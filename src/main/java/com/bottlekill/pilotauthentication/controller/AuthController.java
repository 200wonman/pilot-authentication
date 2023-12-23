package com.bottlekill.pilotauthentication.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

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
}