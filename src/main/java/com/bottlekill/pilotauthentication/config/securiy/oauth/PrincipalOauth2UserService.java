package com.bottlekill.pilotauthentication.config.securiy.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;


//public class PrincipalOauth2UserService extends DefaultO{
//@Service
//public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {


    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("user Request : " + userRequest);

        return super.loadUser(userRequest);
    }
}

