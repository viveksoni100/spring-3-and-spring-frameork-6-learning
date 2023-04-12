package com.vivek.myFirstWebApplication.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

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

    /**
     *
     * csrf will prevent third party urls such as h2-console or swagger-ui.html
     * that's why we are disabling it from spring security context
     */
    //CSRF/cross site request forgery disable
    //frame
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> auth.anyRequest().authenticated());
        http.formLogin(Customizer.withDefaults());

        http.csrf().disable();
        http.headers().frameOptions().disable();

        return http.build();
    }

}
