package com.alexdevprates.backendstatustreinamentos.controller;

import com.alexdevprates.backendstatustreinamentos.dto.FuncionarioTreinamentoDTO;
import com.alexdevprates.backendstatustreinamentos.service.FuncionarioTreinamentoService;
import com.alexdevprates.backendstatustreinamentos.utils.MensagensReponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/funcionariotreinamento")
public class FuncionarioTreinamentoController {
    @Autowired
    FuncionarioTreinamentoService funcionarioTreinamentoService;

    @GetMapping
    public ResponseEntity<?> listaFuncionariosComTreinamentos(){
        return ResponseEntity.ok().body(this.funcionarioTreinamentoService.listaTreinamentosVinculados());
    }

    @PostMapping(value = "/vincular")
    public ResponseEntity<?> List(@RequestBody FuncionarioTreinamentoDTO funcionarioTreinamentoDTO) throws Exception{
        this.funcionarioTreinamentoService.associarTreinamento(funcionarioTreinamentoDTO);
        return ResponseEntity.ok(MensagensReponseEntity.FUNCIONARIO_ASSOCIADO_SUCESSO);
    }



}
