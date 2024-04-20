package com.alexdevprates.backendstatustreinamentos.controller;

import com.alexdevprates.backendstatustreinamentos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
}
