package com.pjff.curso.springboot.error.springboot_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pjff.curso.springboot.error.springboot_error.models.domain.User;

@Service
// Paso 2.2 , implementamos la interfaz
public class UserServiceImpl implements UserService {

    // Paso 2.22 inyectamos con autowired que viene de Appcongif
    @Autowired
    private List<User> users;

    @Override
    public List<User> findAll() {
        // devolvemos la lista
        return users;
    }

    @Override
    // paso 2.19, optional
    public Optional<User> findById(Long id) {
        /*
         * buscamos el objeto
         * usr.getId().equals(id), si es igual al id que estamos buscando por argumento.
         * paso 2.23,programacion funcional usr es de user
         */
        return users.stream().filter(usr -> usr.getId().equals(id)).findFirst();

        /*
         * si se cumple lo filtramos , y sino no se filtra,
         * find first regresa un objeto optional de usuario
         * extrae del flujo encontrado en un optional
         * y si lo encuentra sera un objeto con valor y sino sera empty
         */
    }

}
