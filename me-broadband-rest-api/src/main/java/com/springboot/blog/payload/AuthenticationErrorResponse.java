package com.springboot.blog.payload;

public class AuthenticationErrorResponse {
    private String errorMessage;

    public AuthenticationErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    // Getters and setters
}
