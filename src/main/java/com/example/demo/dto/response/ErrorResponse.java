package com.example.demo.dto.response;

import lombok.Getter;
import lombok.Setter;

public class ErrorResponse {
    @Getter
    @Setter
    private int status;
    @Getter
    @Setter
    private String message;
    @Getter
    @Setter
    private String timestamp;

    public ErrorResponse() {}

    public ErrorResponse(int status, String message, String timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }
}
