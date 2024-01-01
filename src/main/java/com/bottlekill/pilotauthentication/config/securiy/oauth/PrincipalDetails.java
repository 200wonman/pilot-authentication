package com.bottlekill.pilotauthentication.config.securiy.oauth;

import com.bottlekill.pilotauthentication.controller.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
@Slf4j
public class PrincipalDetails implements /*UserDetails, */OAuth2User {
    private final User user;
    private final Map<String, Object> attributes;

    // OAuth2.0 로그인시 사용
    public PrincipalDetails(User user, Map<String, Object> attributes) {
        this.user = user;
        this.attributes = attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
        collet.add(()->{ return user.getRole();});
        return collet;
    }

    // 리소스 서버로 부터 받는 회원정보
    @Override
    public Map<String, Object> getAttributes() {

        return attributes;
    }



    @Override
    public String getName() {
        return user.getId()+"";
    }
}
