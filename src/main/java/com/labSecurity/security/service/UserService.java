package com.labSecurity.security.service;

import com.labSecurity.security.models.User;
import com.labSecurity.security.repository.RoleRepository;
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
    @Autowired
    private RoleRepository roleRepository;

    public boolean createUser(User user) {
        try {

            // set the user properties
            User newuser = new User();
            newuser.setUsername(user.getUsername());
            newuser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(newuser);
            // Assign the  role to the user
            user.getRole().forEach(role -> {
                // Find the id by its Username
                User userId = userRepository.findIdByUsername(user.getUsername());
                role.setUser(userId);
                // Save the role
                roleRepository.save(role);
            });

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
