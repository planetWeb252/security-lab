package com.labSecurity.security.service;

import com.labSecurity.security.models.Role;
import com.labSecurity.security.models.User;
import com.labSecurity.security.repository.RolesRepository;
import com.labSecurity.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RolesRepository rolesRepository;

    public boolean createUser(User user) {
        try {
            System.out.println(user);
            // set the user properties
            User newuser = new User();
            newuser.setUsername(user.getUsername());
            newuser.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(newuser);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public boolean checkPassword(User user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }









}
