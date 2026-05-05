package com.example.demo.service;

import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserPatchRequest;
import com.example.demo.dto.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {
    List<UserResponse> getUsers(String sortedBy, String filter);

    UserResponse createUser(UserCreateRequest request);

    UserResponse updateUser(UUID id, UserPatchRequest request);

    void deleteUser(UUID id);
}
