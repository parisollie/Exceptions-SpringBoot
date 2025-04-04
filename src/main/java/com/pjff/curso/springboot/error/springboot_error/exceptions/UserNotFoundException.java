package com.pjff.curso.springboot.error.springboot_error.exceptions;

//Paso 2.14
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
