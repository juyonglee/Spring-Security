package com.gmail.juyonglee0208.helloworld.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MySecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withUsername("user").password(passwordEncoder().encode("0000"))
            .roles("USER").build();
        UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("0000"))
            .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }
}
