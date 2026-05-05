package com.example.demo.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserCreateRequest {
    @Getter
    @Setter
    @Email(message = "Email format is invalid")
    @NotBlank(message = "Email is required")
    private String email;

    @Getter
    @Setter
    @NotBlank(message = "Name is required")
    private String name;

    @Getter
    @Setter
    @NotBlank(message = "Phone is required")
    private String phone;

    @Getter
    @Setter
    @NotBlank(message = "Password is required")
    private String password;

    @Getter
    @Setter
    @NotBlank(message = "Tax ID is required")
    private String taxId;

    @Getter
    @Setter
    @Valid
    @NotEmpty(message = "One address is required")
    private List<AddressRequest> addresses;
}
