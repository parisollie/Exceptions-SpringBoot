package com.pjff.curso.springboot.error.springboot_error.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.pjff.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.pjff.curso.springboot.error.springboot_error.models.Errors;

//V-80,paso 1.3, creamos el HandlerExceptionController
@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler({ ArithmeticException.class })
    // Paso 1.4 Errros es de nosotros
    public ResponseEntity<Errors> divisionByZero(Exception ex) {

        // V-81,paso 1.6 Creamos una nueva instancia
        Errors error = new Errors();
        error.setDate(new Date());
        error.setError("Error division por cero!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());

        /*
         * Paso 1.5, return ResponseEntity.internalServerError().body(error);
         * Esta es otra forma de escribir la parte de arriba.
         */
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);
    }

    // Paso 1.10,esta es otra forma de hacerla
    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> numberFormatException(Exception ex) {

        // Importamos el mapa
        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "número inválido o incorrecto, no tiene formato de dígito!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }

    // V-82,paso 1.7 cuando hay eror 404,esta es una forma mejor
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Errors> notFoundEx(NoHandlerFoundException e) {
        Errors error = new Errors();
        error.setDate(new Date());
        error.setError("Api rest no encontrado");
        error.setMessage(e.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());

        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    /*
     * V-86,paso 2.13 para cachar la excepcion NullPointerException. y usuario no
     * encontrado.
     * Paso 2.16, le agreamos el UserNotFoundException.class, cualquiera que caiga
     * de
     * las 3 le mandaremos el mensaje de abajo ,
     */
    @ExceptionHandler({ NullPointerException.class,
            HttpMessageNotWritableException.class,
            UserNotFoundException.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> userNotFoundException(Exception ex) {

        Map<String, Object> error = new HashMap<>();
        error.put("date", new Date());
        error.put("error", "el usuario o role no existe!");
        error.put("message", ex.getMessage());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());

        return error;
    }
}
