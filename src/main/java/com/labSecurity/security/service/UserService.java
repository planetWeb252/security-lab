package com.labSecurity.security.service;

import com.labSecurity.security.models.User;
import com.labSecurity.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public boolean createUser(User user) {
        try {
            // set the user properties
            User newuser = new User();
            newuser.setUsername(user.getUsername());
            newuser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
