package com.labSecurity.security.repository;

import com.labSecurity.security.models.Role;
import com.labSecurity.security.models.Roles_Enum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolesRepository extends JpaRepository<Role, Long> {

    Role findByName(Roles_Enum name);
}
