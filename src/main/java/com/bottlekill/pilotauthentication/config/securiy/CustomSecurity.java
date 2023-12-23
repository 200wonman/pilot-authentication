package com.bottlekill.pilotauthentication.config.securiy;

import com.bottlekill.pilotauthentication.config.securiy.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class CustomSecurity {
    
    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .formLogin().disable()
                .httpBasic().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and() // 세션 생성 정책 설정: STATELESS (상태 정보를 서버에 저장하지 않음)
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.POST, "/admin").hasRole("ADMIN")
                        .anyRequest().permitAll()

                )
                // OAuth2 로그인 구성 추가
                .oauth2Login(oauth2Login -> oauth2Login
                                .loginPage("/login") // 사용자 정의 로그인 페이지 (옵션)
                                // 추가적인 OAuth2 로그인 구성...
                                .userInfoEndpoint()
                                .userService(principalOauth2UserService)
                )
                .build();
    }
}
