package com.alexdevprates.backendstatustreinamentos.service;


import com.alexdevprates.backendstatustreinamentos.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinamentoService {

    @Autowired
    TreinamentoRepository treinamentoRepository;
}
