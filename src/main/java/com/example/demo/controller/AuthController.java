package com.example.demo.controller;

import com.example.demo.dto.request.LoginRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@Tag(name = "Auth", description = "User Auth operations")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    @Operation(
            summary = "Authentication service",
            description = "System authentication service for users"
    )
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        UserResponse user = authService.login(request.getTaxId(), request.getPassword());

        if  (user == null)
            return ResponseEntity.status(401).body("Invalid credentials");

        return ResponseEntity.ok(user);
    }
}
