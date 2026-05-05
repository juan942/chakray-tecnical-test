package com.example.demo.service.impl;

import com.example.demo.dto.response.UserResponse;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.service.AuthService;
import com.example.demo.service.UserService;
import com.example.demo.utils.AesEncryptionUtil;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    private final UserService userService;

    public AuthServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserResponse login(String taxId, String password) {
        User user = userService.findUserByTaxId(taxId);

        if (user == null)
            return null;

        String passwordEncrypted = AesEncryptionUtil.encrypt(password);
        if (!user.getPassword().equals(passwordEncrypted))
            return null;

        return UserMapper.toResponse(user);
    }
}
