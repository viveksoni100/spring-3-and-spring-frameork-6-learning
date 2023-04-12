package com.vivek.myFirstWebApplication.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    //LDAP or Database
    //InMemory

    @Bean
    public InMemoryUserDetailsManager createUserDetailsManager() {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
        UserDetails userDetails = createNewUser(passwordEncoder, "vivek", "pass");
        UserDetails userDetailsNew = createNewUser(passwordEncoder, "devangi", "password");

        return new InMemoryUserDetailsManager(userDetails, userDetailsNew);
    }

    private UserDetails createNewUser(Function<String, String> passwordEncoder, String username, String password) {
        return User.builder()
                    .passwordEncoder(passwordEncoder)
                    .username(username)
                    .password(password)
                    .roles("USER", "ADMIN")
                    .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
