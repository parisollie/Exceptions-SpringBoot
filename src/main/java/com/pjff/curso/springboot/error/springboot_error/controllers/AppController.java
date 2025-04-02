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
        // Vid 78,emulando un error
        // int value = 100 / 0;
        // Vid 83,convertyimos un entero con un string para que nos lance la excepcion.
        int value = Integer.parseInt("20x");
        System.out.println(value);
        return "ok 200";
    }

}*/

@RestController
// Vid 85,@RequestMapping, la raiz queda en app
@RequestMapping("/app")
public class AppController {

    // Vid 84, inyectamos con autowired
    @Autowired
    private UserService service;

    @GetMapping
    public String index() {
        // int value = 100 / 0;
        int value = Integer.parseInt("20x");
        System.out.println(value);
        return "ok 200";
    }

    // Vid 85
    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id) {
        // encuentra el id o arrojar un error
        // Vid 86, new UserNotFoundException("Error el usuario no existe!")
        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("Error el usuario no existe!"));
        System.out.println(user.getLastname());
        return user;
    }
}
