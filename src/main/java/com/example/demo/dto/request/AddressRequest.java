package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class AddressRequest {
    @Getter
    @Setter
    @NotNull(message = "Address ID is required")
    private Long id;

    @Getter
    @Setter
    @NotBlank(message = "Address name is required")
    private String name;

    @Getter
    @Setter
    @NotBlank(message = "Street is required")
    private String street;

    @Getter
    @Setter
    @NotBlank(message = "Country code is required")
    private String countryCode;
}
