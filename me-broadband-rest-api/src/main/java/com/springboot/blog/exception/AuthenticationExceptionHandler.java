package com.springboot.blog.exception;

import com.springboot.blog.payload.AuthenticationErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthenticationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Object> handleBadCredentialsException(BadCredentialsException ex) {
        AuthenticationErrorResponse errorResponse = new AuthenticationErrorResponse("Invalid credentials");

        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }
}
