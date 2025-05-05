package com.labSecurity.security.controllers;

import com.labSecurity.security.exceptions.UserExceptions.messagesExceptionsUser;
import com.labSecurity.security.models.User;
import com.labSecurity.security.repository.UserRepository;
import com.labSecurity.security.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }


    /**
     * Create a new user, if the user already exists, return a 200 OK response
     * else the method will a new password.
     */
    @PostMapping
    public ResponseEntity<String> createUser(@RequestBody User user) {
        try {
            Optional<User> userOptional =  userRepository.findByUsername(user.getUsername());
            // Check if the user already exists
            if(userOptional.isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(user.getUsername()+" "+messagesExceptionsUser.USERNAME_ALREADY_EXISTS);
            }else{
                // If the user does not exist, create a new user in service
                boolean responseUser = userService.createUser(user);
                if (responseUser) {
                    return ResponseEntity.status(HttpStatus.CREATED).body(messagesExceptionsUser.USER_CREATED);
                } else {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(messagesExceptionsUser.USER_ERROR_CREATING);
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }


    }



}
