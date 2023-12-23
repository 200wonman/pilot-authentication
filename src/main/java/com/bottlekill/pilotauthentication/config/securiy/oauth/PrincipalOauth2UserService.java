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

        System.out.println("user Request1 : " + userRequest.getClientRegistration());
//        getClientRegistration() 메소드는
//        OAuth2UserRequest 객체에서 호출됩니다. 인증 과정에 사용된 OAuth 2.0 클라이언트의 등록 정보를 반환합니다.
//        클라이언트 등록 정보(ClientRegistration)에는 OAuth 2.0 공급자(예: Google, Facebook 등)에 대한 구성 세부 정보가 포함되어 있습니다.
//        이 정보는 OAuth 2.0 인증 과정을 시작하고, 사용자 정보를 요청하며, 토큰을 교환할 때 필요한 중요한 정보를 담고 있습니다.
//        1. 클라이언트 ID(Client ID): OAuth 2.0 공급자에 등록할 때 제공받는 고유 식별자입니다.
//        2. 클라이언트 비밀(Client Secret): 클라이언트 인증에 사용되는 비밀 키입니다.
//        3. 리다이렉트 URI(Redirect URI): OAuth 2.0 공급자가 인증 후 사용자를 리다이렉트할 URI입니다.
//        4. 인증 및 토큰 엔드포인트(Authorization and Token Endpoints): OAuth 2.0 공급자의 인증 및 토큰 교환을 위한 엔드포인트 주소입니다.
//        5. 스코프(Scopes): 애플리케이션이 요청하는 액세스 범위. 예를 들어, 사용자 프로필 정보, 이메일 주소 등에 대한 접근 권한을 의미합니다.
//         ClientRegistration{registrationId='google',
//         clientId='533338826248-vtbnpfb5stj298ka2rquk244bhpu1ge3.apps.googleusercontent.com',
//         clientSecret='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',
//         clientAuthenticationMethod=org.springframework.security.oauth2.core.ClientAuthenticationMethod@4fcef9d3,
//         authorizationGrantType=org.springframework.security.oauth2.core.AuthorizationGrantType@5da5e9f3,
//         redirectUri='{baseUrl}/{action}/oauth2/code/{registrationId}',
//         scopes=[email, profile],
//         providerDetails=org.springframework.security.oauth2.client.registration.ClientRegistration$ProviderDetails@2698167,
//         clientName='Google'}


        System.out.println("user Request2 : " + userRequest.getAccessToken().getTokenValue());
//        액세스 토큰(Access Token)은 OAuth2 인증 프로세스의 중요한 부분으로,
//        클라이언트(여기서는 당신의 애플리케이션)가 리소스 서버(예: 사용자 정보를 제공하는 Google, Facebook 서버 등)에
//        접근할 수 있는 권한을 증명하는데 사용됩니다.

        // 유저 정보들 보기
        System.out.println("user Request3 : " + super.loadUser(userRequest).getAttributes());
//        user Request3 : {sub=106694311679003849089,
//        name=김주예, given_name=주예, family_name=김,
//        picture=https://lh3.googleusercontent.com/a/ACg8ocIiZP3oxetgmpSm-5jAGhZiVj4DHz3hGeFA0eUEB6lU=s96-c,
//        email=rlawndp@gmail.com,
//        email_verified=true,
//        locale=ko}


            return super.loadUser(userRequest); // 그럼 유저정보들을 반환하게됨
    }
}

