package com.example.demo.service;

import com.example.demo.dto.response.UserResponse;

public interface AuthService {
    UserResponse login(String taxId, String password);
}
