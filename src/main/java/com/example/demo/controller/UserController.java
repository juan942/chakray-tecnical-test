package com.example.demo.controller;

import com.example.demo.dto.request.UserCreateRequest;
import com.example.demo.dto.request.UserPatchRequest;
import com.example.demo.dto.response.UserResponse;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "User related operations")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(
            summary = "Get the list of users",
            description = "Get the complete list of users with the option to sort and filter"
    )
    public ResponseEntity<List<UserResponse>> getUsers(@RequestParam(required = false) String sortedBy, @RequestParam(required = false) String filter) {
        List<UserResponse> users = userService.getUsers(sortedBy, filter);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    @Operation(
            summary = "Create new user",
            description = "Register a new user un the system"
    )
    public ResponseEntity<UserResponse> createUser(@Valid @RequestBody UserCreateRequest request) {
        UserResponse cretedUser = userService.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(cretedUser);
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Update user",
            description = "Update the information for a specific user"
    )
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID id, @Valid @RequestBody UserPatchRequest request) {
        UserResponse updatedUser = userService.updateUser(id, request);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Delete user",
            description = "Delete a specific user information"
    )
    public ResponseEntity<UserResponse> deleteUser(@PathVariable UUID id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
