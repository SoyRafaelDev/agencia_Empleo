package com.rafaelgonzalez.application.init;

import com.rafaelgonzalez.application.model.Role;
import com.rafaelgonzalez.application.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static java.util.Arrays.asList;

@Component
@RequiredArgsConstructor
public class ApplicationStartRunner implements CommandLineRunner {
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        Role roleAdmin = new Role(1L, "123", "ROLE_ADMIN");
        Role roleUser = new Role(2L, "456", "ROLE_USER");
        roleRepository.saveAll(asList(roleUser, roleAdmin));
    }
}
