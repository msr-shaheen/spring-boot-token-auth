package com.shaheen.msr.tokenauth.response;

import lombok.Data;

@Data
public class ErrorDetails {
    private String field;
    private String message;

    public ErrorDetails(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
