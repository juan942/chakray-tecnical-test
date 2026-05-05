package com.example.demo.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(
            regexp = "^(\\+?\\d{2})?\\d{10}$",
            message = "The phone must be 10 digits long, the country code is optional"
    )
    private String phone;

    @Getter
    @Setter
    @NotBlank(message = "Password is required")
    private String password;

    @Getter
    @Setter
    @NotBlank(message = "Tax ID is required")
    @Pattern(
            regexp = "^[A-ZÑ&]{4}\\d{6}[A-Z0-9]{3}$",
            message = "The tax_id must have a valid format, example: AARR990101XXX"
    )
    private String taxId;

    @Getter
    @Setter
    @Valid
    @NotEmpty(message = "One address is required")
    private List<AddressRequest> addresses;
}
