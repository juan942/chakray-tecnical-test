package com.example.demo.dto.request;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class UserPatchRequest {
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
    private String password;
    @Getter
    @Setter
    private String taxId;
    @Valid
    @Getter
    @Setter
    private List<AddressRequest> addresses;

}
