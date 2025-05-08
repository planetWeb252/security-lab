package com.labSecurity.security.controllers.routeProtectedController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController@RequestMapping("/moderator")
public class ModeratorController {

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {

            return ResponseEntity.ok("Hello from ModeratorController");

    }


}
