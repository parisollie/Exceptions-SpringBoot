package com.pjff.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import com.pjff.curso.springboot.error.springboot_error.models.domain.User;

public interface UserService {

    // Vid 84, tenemos un listado y devuelve todos.
    List<User> findAll();

    // Vid 87, el optional podria contenerlo o no
    Optional<User> findById(Long id);

}
