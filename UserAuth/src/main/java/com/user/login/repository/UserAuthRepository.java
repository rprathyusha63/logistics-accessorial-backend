package com.user.login.repository;

import com.user.login.domain.UserAuth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthRepository extends JpaRepository<UserAuth, String> {
    public Optional<UserAuth> findByEmail(String email);
}