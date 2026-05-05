package com.example.demo.enums;

import lombok.Getter;

public enum FilterOperation {
    CONTAINS("co"),
    EQUALS("eq"),
    STARTS_WITH("sw"),
    ENDS_WITH("ew");

    @Getter
    private final String value;

    FilterOperation(String value) {
        this.value = value;
    }
}
