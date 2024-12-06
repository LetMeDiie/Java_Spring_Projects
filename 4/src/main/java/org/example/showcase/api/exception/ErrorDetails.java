package org.example.showcase.api.exception;

import lombok.Data;

@Data
public class ErrorDetails {
    private String error;
    private String message;

    public ErrorDetails(String error, String message) {
        this.error = error;
        this.message = message;
    }
}
