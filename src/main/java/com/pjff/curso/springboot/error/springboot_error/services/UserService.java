package com.pjff.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.pjff.curso.springboot.error.springboot_error.models.domain.User;

public interface UserService {

    // Paso 2.1, tenemos un listado y devuelve todos.
    List<User> findAll();

    // V-87,paso 2.18 el optional podria contenerlo o no
    Optional<User> findById(Long id);

}
