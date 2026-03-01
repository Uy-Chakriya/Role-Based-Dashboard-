package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initUsers(UserRepository repo, PasswordEncoder encoder) {
        return args -> {
            if(repo.findByUsername("admin").isEmpty()) {
                repo.save(new User(null, "admin", encoder.encode("admin123"), "ADMIN"));
            }
            if(repo.findByUsername("user").isEmpty()) {
                repo.save(new User(null, "user", encoder.encode("user123"), "USER"));
            }
        };
    }
}