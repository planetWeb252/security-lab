package com.labSecurity.security.controllers;

import com.labSecurity.security.models.User;
import com.labSecurity.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class loginController {
    @Autowired
    private UserRepository userRepository;

    /*
    * the login controller
    * first we need to create a user
    * then we need to create a login whit the user
    * create a token if the user is valid and if the user exists in the bbdd
    * */
    @PostMapping
    public ResponseEntity<?> login(@RequestBody User user) {
        return ResponseEntity.ok("Login successful");

    }
}
