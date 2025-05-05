package com.labSecurity.security.repository;

import com.labSecurity.security.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {

}
