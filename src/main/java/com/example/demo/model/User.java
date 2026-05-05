package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class User {
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
    private String password;
    @Getter
    @Setter
    private String taxId;
    @Getter
    @Setter
    private LocalDateTime createdAt;
    @Getter
    @Setter
    private List<Address> addresses;

    public User() {}

    public User(UUID id, String email, String name, String phone, String password, String taxId, LocalDateTime createdAt, List<Address> addresses) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.taxId = taxId;
        this.createdAt = createdAt;
        this.addresses = addresses;
    }

}
