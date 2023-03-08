package com.carlosdiaz.seguridad.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;

import com.carlosdiaz.seguridad.models.User;
import com.carlosdiaz.seguridad.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class UsuarioController {
    @Autowired
    UserService service;

    @GetMapping("/usuario/{nombre}")
    UserDetails findUsuario(@PathVariable String nombre) {
        return service.loadUserByUsername(nombre);
    }
    
}
