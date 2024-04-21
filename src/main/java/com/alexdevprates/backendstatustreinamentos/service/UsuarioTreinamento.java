package com.alexdevprates.backendstatustreinamentos.service;

import com.alexdevprates.backendstatustreinamentos.repository.TreinamentoRepository;
import com.alexdevprates.backendstatustreinamentos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioTreinamento {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TreinamentoRepository treinamentoRepository;
}
