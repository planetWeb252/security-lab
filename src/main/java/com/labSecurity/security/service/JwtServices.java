package com.labSecurity.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import com.labSecurity.security.models.Role;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class JwtServices {
    private static final String SECRET = "@Secret_Key";

    public String generateToken(String username, Collection<Role> roles) {
        String[] roleNames = roles.stream()
                .map(role -> role.getName().name())
                .toArray(String[]::new);

        return JWT.create()
                .withSubject(username)
                .withArrayClaim("roles", roleNames)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 60 * 1000))
                .sign(Algorithm.HMAC256(SECRET));
    }

    public boolean validateToken(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
            return true;
        } catch (JWTVerificationException e) {
            return false;
        }
    }

    // Method to extract username (subject) from the token
    public String extractUsername(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token)
                .getSubject();
    }

    // Method to extract roles from the token
    public List<String> extractRoles(String token) {
        DecodedJWT jwt = JWT.require(Algorithm.HMAC256(SECRET))
                .build()
                .verify(token);

        return jwt.getClaim("roles").asList(String.class);
    }
}
