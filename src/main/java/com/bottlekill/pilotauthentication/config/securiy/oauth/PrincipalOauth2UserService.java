package com.bottlekill.pilotauthentication.config.securiy.oauth;

import com.bottlekill.pilotauthentication.controller.model.User;
import com.bottlekill.pilotauthentication.controller.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserRepository userRepository;

    // sns로그인 데이터를 후처리하는곳
    // 참조 : docs/about_Oauth2.md
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {



        OAuth2User oAuth2User = super.loadUser(userRequest);

        String provider = userRequest.getClientRegistration().getClientId();//google
        String providerId = oAuth2User.getAttribute("sub");
        String email = oAuth2User.getAttribute("email");
        String username = provider + "_" + providerId; // 중복제거를 위해 조합
        String role = "ROLE_USER";

        User userEntity =  userRepository.findByUsername(username);

        if (userEntity==null){
            userEntity = User.builder()
                    .username(username)
                    .email(email)
                    .role(role)
                    .providerId(providerId)
                    .provider(provider)
                    .build();
            userRepository.save(userEntity);
        }

        return new PrincipalDetails(userEntity,oAuth2User.getAttributes());
    }
}

