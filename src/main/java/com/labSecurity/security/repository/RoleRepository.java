package com.labSecurity.security.repository;

import com.labSecurity.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
