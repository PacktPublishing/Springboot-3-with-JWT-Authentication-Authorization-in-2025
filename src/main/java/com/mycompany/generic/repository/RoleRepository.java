package com.mycompany.generic.repository;

import com.mycompany.generic.constant.ERole;
import com.mycompany.generic.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    Optional<RoleEntity> findByName(ERole name);
}
