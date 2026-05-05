package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

public class Address {
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String street;
    @Getter
    @Setter
    private String countryCode;

    public Address() {}

    public Address(Long id, String name, String street, String countryCode) {
        this.id = id;
        this.name = name;
        this.street = street;
        this.countryCode = countryCode;
    }

}
