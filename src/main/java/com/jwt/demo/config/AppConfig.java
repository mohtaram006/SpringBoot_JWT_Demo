package com.jwt.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {
    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }
  //  For innner memory
/*
    @Bean
    public UserDetailsService userDetailsService() {
        String encodedPassword = passwordEncoder().encode("saad");
        UserDetails user = User.builder().username("maaz").password(encodedPassword).roles("ADMIN").build();
        UserDetails user1 = User.builder().username("mohtaram").password(encodedPassword).roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, user1);
    }
*/


}
