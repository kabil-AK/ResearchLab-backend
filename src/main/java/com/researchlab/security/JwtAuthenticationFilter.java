package com.researchlab.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.researchlab.repository.AdminUserRepository;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final AdminUserRepository adminUserRepository;

    public JwtAuthenticationFilter(JwtService jwtService, AdminUserRepository adminUserRepository) {
        this.jwtService = jwtService;
        this.adminUserRepository = adminUserRepository;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            try {
                String email = jwtService.extractEmail(token);

                if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                    adminUserRepository.findByEmail(email).ifPresent(admin -> {
                        if (jwtService.isValid(token, admin.getEmail())) {
                            var auth = new UsernamePasswordAuthenticationToken(
                                    admin.getEmail(),
                                    null,
                                    List.of(new SimpleGrantedAuthority("ROLE_ADMIN"))
                            );
                            SecurityContextHolder.getContext().setAuthentication(auth);
                        }
                    });
                }
            } catch (Exception ignored) {
                // Invalid token is simply treated as unauthenticated.
            }
        }

        filterChain.doFilter(request, response);
    }
}
