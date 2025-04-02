package com.pjff.curso.springboot.error.springboot_error.exceptions;

//Vid 86
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
