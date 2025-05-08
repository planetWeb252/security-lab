package com.labSecurity.security.controllers.routeProtectedController;


import com.labSecurity.security.models.User;
import com.labSecurity.security.security.JwtAuthenticationFilter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/routeRequiredAuth")
public class routeRequiredAuth {



    @PostMapping("/authenticated")
    public ResponseEntity<?> authenticated(@RequestBody User user) {
        String username = user.getUsername();
        return ResponseEntity.ok("Hello " + username + ", this route is protected and you are authenticated.");
    }

}
