package com.jwt.demo.security;

import java.io.IOException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        // Respond with a 401 Unauthorized status and custom message
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write("Access Denied: Please authenticate to access this resource.");
    }

}
