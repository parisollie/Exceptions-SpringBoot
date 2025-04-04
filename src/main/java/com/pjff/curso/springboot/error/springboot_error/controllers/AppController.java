package com.pjff.curso.springboot.error.springboot_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pjff.curso.springboot.error.springboot_error.exceptions.UserNotFoundException;
import com.pjff.curso.springboot.error.springboot_error.models.domain.User;
import com.pjff.curso.springboot.error.springboot_error.services.UserService;

/*@RestController
public class AppController {

    // Rutas para trabajar
    // localhost:8080/app/otro
    // localhost:8080/app

    // Mapeamos a la ruta app
    @GetMapping("/app")
    public String index() {
        // V-78,paso 1.0 emulando un error
        // int value = 100 / 0;
        // convertimos un entero con un string para que nos lance la excepcion.
        int value = Integer.parseInt("20x");
        System.out.println(value);
        return "ok 200";
    }

}*/

@RestController
// V-85,paso 2.5 @RequestMapping, la raiz queda en app
@RequestMapping("/app")
public class AppController {

    // Paso 2.9,inyectamos con autowired?
    @Autowired
    // Paso 2.4
    private UserService service;

    @GetMapping
    public String index() {
        // int value = 100 / 0;
        // V-83,paso 1.9
        int value = Integer.parseInt("20x");
        System.out.println(value);
        return "ok 200";
    }

    // Paso 2.6
    @GetMapping("/show/{id}")
    // Paso 2.8
    public User show(@PathVariable(name = "id") Long id) {
        /*
         * encuentra el id o arrojar un error
         * Paso 2.15, new UserNotFoundException("Error el usuario no existe!")
         * Paso 2.20
         */
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe!"));
        System.out.println(user.getLastname());

        // Paso 2.7
        return user;
    }
}
