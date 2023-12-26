package com.bottlekill.pilotauthentication.controller.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
public class User {

    @Id @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String email;
    private String role;
    @CreationTimestamp
    private Timestamp createDate;
}
