package com.user.login.service;

import com.user.login.domain.UserAuth;
import com.user.login.repository.UserAuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAuthService {
    @Autowired
    private UserAuthRepository userAuthRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<UserAuth> getUserAuths() {
        return userAuthRepository.findAll();
    }

    public UserAuth createUserAuth(UserAuth userAuth){

        userAuth.setPassword(passwordEncoder.encode(userAuth.getPassword()));

        return userAuthRepository.save(userAuth);
    }
}

