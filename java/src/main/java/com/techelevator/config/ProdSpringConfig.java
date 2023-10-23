package com.techelevator.config;

import com.techelevator.repo.AppUserRepo;
import com.techelevator.repo.RoleRepo;
import com.techelevator.service.AppUserService;
import com.techelevator.service.RecipeService;
import com.techelevator.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("prod")
public class ProdSpringConfig {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private AppUserRepo appUserRepo;

    @Bean
    CommandLineRunner run(AppUserService appUserService, RoleService roleService, RecipeService recipeService) {
        return args -> {

//            AppUser brandon = AppUser.builder()
//                    .username("brandon")
//                    .password(passwordEncoder.encode("brandon123"))
//                    .activated(true)
//                    .build();
//
//            appUserService.addUser(brandon);
//
//            Role userRole = Role.builder()
//                    .name("ROLE_USER")
//                    .appUserRoles(Set.of(brandon))
//                    .build();
//
//            Role adminRole = Role.builder()
//                    .name("ROLE_ADMIN")
//                    .appUserRoles(Set.of(brandon))
//                    .build();
//
//            roleRepo.save(userRole);
//            roleRepo.save(adminRole);

//                     AppUser chantele = AppUser.builder()
//                                .username("chantele")
//                                .password(passwordEncoder.encode("chantele123"))
//                                .activated(true)
//                                .build();
//
//                    appUserService.addUser(chantele);
//
//                    Role userRole = roleRepo.findByName("ROLE_USER");
//                    Role adminRole = roleRepo.findByName("ROLE_ADMIN");
//                    userRole.getAppUserRoles().add(chantele);
//                    adminRole.getAppUserRoles().add(chantele);
//
//                    roleRepo.save(userRole);
//                    roleRepo.save(adminRole);
//
//                    appUserRepo.save(chantele);
        };
    }
}
