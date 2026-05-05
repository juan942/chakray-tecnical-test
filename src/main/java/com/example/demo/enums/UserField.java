package com.example.demo.enums;

import lombok.Getter;

public enum UserField {
    ID("id"),
    EMAIL("email"),
    NAME("name"),
    PHONE("phone"),
    TAX_ID("tax_id"),
    CREATED_AT("created_at");

    @Getter
    private final String value;

    UserField(String value) {
        this.value = value;
    }
}
