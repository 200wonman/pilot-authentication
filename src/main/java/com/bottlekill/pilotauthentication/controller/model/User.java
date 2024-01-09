package com.bottlekill.pilotauthentication.controller.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Table(name = "users")
@NoArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String username; // 구굴 : google_sub data
    private String email; // 구글 이메일주소
    private String role; // role_user
    private String provider; // google, naver..
    private String providerId; // sub data
    @CreationTimestamp
    private Timestamp createDate;

    @Builder
    public User(String username, String email, String role, String provider,
                String providerId, Timestamp createDate) {
        this.username = username;
        this.email = email;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.createDate = createDate;
    }


    public void setEmail(String email) {
        this.email = email;
    }
}
