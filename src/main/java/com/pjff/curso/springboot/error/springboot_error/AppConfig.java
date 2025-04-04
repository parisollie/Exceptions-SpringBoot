package com.pjff.curso.springboot.error.springboot_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.pjff.curso.springboot.error.springboot_error.models.domain.User;

@Configuration
public class AppConfig {

    /*
     * V-88,paso 2.21 lo ponemos en una clase aparte para
     * poder inyectarlo tenemos nuestro método
     */
    @Bean
    List<User> users() {
        // Paso 2.3, creamos nuestra lista de usuarios.
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Ollie", "Gonzalez"));
        users.add(new User(2L, "Andrew", "Riordan"));
        users.add(new User(3L, "Nick", "Perez"));
        users.add(new User(4L, "Sylvain", "Ramirez"));
        users.add(new User(5L, "Till", "Gutierrez"));
        return users;
    }
}
