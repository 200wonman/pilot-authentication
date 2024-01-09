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
                .headers().frameOptions().disable().and()
                .formLogin().disable()
                .httpBasic().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) .and()
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/h2-console/**").permitAll() // /h2-console 경로와 그 하위 경로에 대한 접근을 모든 사용자에게 허용합니다.
                        .requestMatchers("/user/**").authenticated() // 인증된 사용자만 /user 경로에 접근할 수 있음
                        .requestMatchers(HttpMethod.POST, "/admin").hasRole("ADMIN")
                        .anyRequest().permitAll()
                )

                // OAuth2 로그인 구성 추가1
                .oauth2Login(oauth2Login -> oauth2Login
                                .loginPage("/login")
                                .defaultSuccessUrl("/user", true) // OAuth2 로그인 성공 후 /user로 리디렉션
                                .userInfoEndpoint()
                                .userService(principalOauth2UserService)
                )
                .build();
    }
}
