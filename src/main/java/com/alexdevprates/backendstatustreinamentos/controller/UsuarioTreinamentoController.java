package com.alexdevprates.backendstatustreinamentos.controller;

import com.alexdevprates.backendstatustreinamentos.dto.TreinamentoDTO;
import com.alexdevprates.backendstatustreinamentos.dto.UsuarioDTO;
import com.alexdevprates.backendstatustreinamentos.dto.UsuarioTreinamentoDTO;
import com.alexdevprates.backendstatustreinamentos.service.UsuarioTreinamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuariotreinamento")
public class UsuarioTreinamentoController {
    @Autowired
    UsuarioTreinamentoService usuarioTreinamentoService;

    @GetMapping
    public ResponseEntity<?> listaUsuariosComTreinamentos(){
        return ResponseEntity.ok().body(this.usuarioTreinamentoService.listaTreinamentosVinculados());
    }

    @PostMapping(value = "/vincular")
    public ResponseEntity<?> vincularUsuarioNoTreinamento(@RequestBody UsuarioTreinamentoDTO usuarioTreinamentoDTO) throws Exception{
        this.usuarioTreinamentoService.associarTreinamento(usuarioTreinamentoDTO);
        return ResponseEntity.ok("Usuário associado com sucesso");
    }



}
