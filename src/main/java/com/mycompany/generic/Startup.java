package com.mycompany.generic;

import com.mycompany.generic.constant.ERole;
import com.mycompany.generic.entity.RoleEntity;
import com.mycompany.generic.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Startup implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Optional<RoleEntity> optRoleAdmin = roleRepository.findByName(ERole.ROLE_ADMIN);
        if(optRoleAdmin.isEmpty()){
            RoleEntity role = new RoleEntity();
            role.setName(ERole.ROLE_ADMIN);
            roleRepository.save(role);
        }

        Optional<RoleEntity> optRoleOwn = roleRepository.findByName(ERole.ROLE_MODERATOR);
        if(optRoleOwn.isEmpty()){
            RoleEntity role = new RoleEntity();
            role.setName(ERole.ROLE_MODERATOR);
            roleRepository.save(role);
        }

        Optional<RoleEntity> optRoleMe = roleRepository.findByName(ERole.ROLE_USER);
        if(optRoleMe.isEmpty()){
            RoleEntity role = new RoleEntity();
            role.setName(ERole.ROLE_USER);
            roleRepository.save(role);
        }
    }
}
