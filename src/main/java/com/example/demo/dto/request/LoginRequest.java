package com.example.demo.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    @Getter
    @Setter
    @JsonProperty("tax_id")
    @NotBlank(message = "Tax Id is required")
    private String taxId;

    @Getter
    @Setter
    @NotBlank(message = "Password is required")
    private String password;
}
