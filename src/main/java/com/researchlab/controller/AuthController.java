package com.researchlab.controller;

import com.researchlab.repository.AdminUserRepository;
import com.researchlab.security.JwtService;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AdminUserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtService jwtService;

    public AuthController(
            AdminUserRepository repo,
            PasswordEncoder encoder,
            JwtService jwtService) {

        this.repo = repo;
        this.encoder = encoder;
        this.jwtService = jwtService;
    }

    public record LoginRequest(
            @Email @NotBlank String email,
            @NotBlank String password
    ) {
    }

    public record LoginResponse(
            String token,
            String email,
            String role
    ) {
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @Valid @RequestBody LoginRequest request) {

        var admin = repo.findByEmail(request.email());

        if (admin.isEmpty()) {
            return ResponseEntity
                    .status(401)
                    .body("Invalid email or password");
        }

        if (!encoder.matches(
                request.password(),
                admin.get().getPassword())) {

            return ResponseEntity
                    .status(401)
                    .body("Invalid email or password");
        }

        String token = jwtService.generateToken(
                admin.get().getEmail()
        );

        LoginResponse response = new LoginResponse(
                token,
                admin.get().getEmail(),
                admin.get().getRole()
        );

        return ResponseEntity.ok(response);
    }
}