package com.labSecurity.security.controllers.routePublicController;


import com.labSecurity.security.models.Roles_Enum;
import com.labSecurity.security.models.User;
import com.labSecurity.security.repository.UserRepository;
import com.labSecurity.security.service.DTO.UserResponseDTO;
import com.labSecurity.security.service.JwtServices;
import com.labSecurity.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/login")
public class loginPublicController {
    private final UserRepository userRepository;
    private final UserService userService;
    private final JwtServices jwtServices;

    @Autowired
    public loginPublicController(UserRepository userRepository, UserService userService, JwtServices jwtServices) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.jwtServices = jwtServices;
    }


    @PostMapping
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> userOptional = userRepository.findByUsername(user.getUsername());
        if (userOptional.isPresent()) {
            User userFound = userOptional.get();
            if (userService.checkPassword(userFound, user.getPassword())) {

                String token = jwtServices.generateToken(userFound.getUsername(), user.getRole().toString());
                UserResponseDTO userResponseDTO = new UserResponseDTO();
                userResponseDTO.setUsername(user.getUsername());
                userResponseDTO.setToken(token);
                return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
            }

        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");


    }

}
