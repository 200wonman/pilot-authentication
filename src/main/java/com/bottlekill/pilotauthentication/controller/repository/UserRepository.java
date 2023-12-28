package com.bottlekill.pilotauthentication.controller.repository;

import com.bottlekill.pilotauthentication.controller.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // SELECT * FROM user WHERE username = ?1
    User findByUsername(String username);

}
