package com.labSecurity.security.controllers.routeProtectedController;

import com.labSecurity.security.models.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/routeRequiredAuth")
public class routeRequiredAuth {

    @RequestMapping("/authenticated")
    public ResponseEntity<?> authenticated(@RequestBody User user) {

        return "This route is protected and requires authentication.";
    }

}
