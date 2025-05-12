package com.labSecurity.security.controllers.routeProtectedController;


import com.labSecurity.security.models.User;
import com.labSecurity.security.security.JwtAuthenticationFilter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/routeRequiredAuth")
public class routeRequiredAuth {


    @GetMapping("/authenticated")
    public ResponseEntity<?> authenticated(Authentication authentication) {
        if (authentication == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No autorizado");
        }

        String username = authentication.getName();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        return ResponseEntity.ok("Hello " + username + ", your roles are: " + authorities);
    }

}
