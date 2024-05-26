package com.example.demo.init;

import com.example.demo.domain.Authority;
import com.example.demo.domain.Role;
import com.example.demo.feature.authority.AuthorityRepository;
import com.example.demo.feature.role.RoleRepository;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DataInitializer {

    private final AuthorityRepository authorityRepository;
    private final RoleRepository roleRepository;

    @PostConstruct
    @Transactional
    public void initData() {
        initAuthorities();
        initRoles();
    }


    private void initAuthorities() {
        List<String> authorities = List.of("READ", "WRITE", "DELETE");
        if (authorityRepository.count() == 0) {
            authorities.forEach(authority -> {
                var auth = new Authority();
                auth.setName(authority);
                authorityRepository.save(auth);
            });
        }
    }


    public void initRoles() {
        List<String> roles = List.of("ADMIN", "USER");
        for (var role : roles) {
            var allAuthorities = new HashSet<>(authorityRepository.findAll());
            if ( role.equals("ADMIN")) {
                var adminRole = new Role();
                adminRole.setName("ADMIN");
                adminRole.setAuthorities(allAuthorities);
                roleRepository.save(adminRole);
            } else if(role.equals("USER")) {
                var userRole = new Role();
                userRole.setName("USER");
                userRole.setAuthorities(allAuthorities.stream().filter(authority -> authority.getName().equals("READ")).collect(Collectors.toSet()));
                roleRepository.save(userRole);
            }
        }
    }



}
