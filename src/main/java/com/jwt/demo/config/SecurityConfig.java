package com.jwt.demo.config;

import com.jwt.demo.security.JwtAuthenticationEntryPoint;
import com.jwt.demo.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationFilter filter; // Custom filter
    @Autowired
    private JwtAuthenticationEntryPoint point;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    PasswordEncoder passwordEncoder;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())// Disable CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/home/**").authenticated() // Secure /home/** endpoints
                        .requestMatchers("/auth/login").permitAll().requestMatchers("/auth/create-user").permitAll() // Allow access to /auth/login
                        .anyRequest().authenticated() // All other endpoints require authentication
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(point) // Handle unauthenticated access
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Stateless session
                );

        // Add custom filter before UsernamePasswordAuthenticationFilter
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
    @Bean
    public DaoAuthenticationProvider dodaoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;

    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}