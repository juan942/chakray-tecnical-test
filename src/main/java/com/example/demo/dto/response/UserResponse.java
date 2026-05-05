package com.example.demo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

public class UserResponse {
    @Getter
    @Setter
    private UUID id;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String phone;
    @Getter
    @Setter
    @JsonProperty("tax_id")
    private String taxId;
    @Getter
    @Setter
    @JsonProperty("created_at")
    private String createdAt;
    @Getter
    @Setter
    private List<AddressResponse> addresses;
}
