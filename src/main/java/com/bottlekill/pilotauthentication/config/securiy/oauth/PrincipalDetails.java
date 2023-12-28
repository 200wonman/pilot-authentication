package com.bottlekill.pilotauthentication.config.securiy.oauth;

import com.bottlekill.pilotauthentication.controller.model.User;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetails implements /*UserDetails, */OAuth2User {

    private User user;
    private Map<String, Object> attributes;

    // OAuth2.0 로그인시 사용
    public PrincipalDetails(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    // 리소스 서버로 부터 받는 회원정보
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }



    @Override
    public String getName() {
        return null;
    }
}
