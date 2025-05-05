package com.labSecurity.security.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Roles>  role=new ArrayList<>();
}
