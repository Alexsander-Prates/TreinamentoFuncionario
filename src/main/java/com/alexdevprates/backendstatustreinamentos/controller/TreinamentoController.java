package com.alexdevprates.backendstatustreinamentos.controller;

import com.alexdevprates.backendstatustreinamentos.dto.TreinamentoDTO;
import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import com.alexdevprates.backendstatustreinamentos.service.TreinamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/treinamento")
public class TreinamentoController {

    @Autowired
    private TreinamentoService treinamentoService;

    @GetMapping
    public ResponseEntity<?> listTreinamentos() throws Exception {
        return ResponseEntity.ok(this.treinamentoService.listaTreinamentos());

    }

    @GetMapping(value = "/unico")
    public ResponseEntity<TreinamentoDTO> buscarTreinamento(TreinamentoDTO treinamentoDTO) throws Exception {
        return ResponseEntity.ok(this.treinamentoService.buscarTreinamentoPorId(treinamentoDTO));
    }

    @PostMapping(value = "/cadastrar")
    public ResponseEntity<?> cadastroTreinamento(@RequestBody TreinamentoDTO treinamentoDTO) throws Exception {
        this.treinamentoService.cadastrarTreinamento(treinamentoDTO);
        return ResponseEntity.ok("Treinamento cadastrado com sucesso");
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<TreinamentoDTO> alteraTreinamento(@RequestBody TreinamentoDTO treinamentoDTO) throws Exception{
        return ResponseEntity.ok(this.treinamentoService.alterarTreinamento(treinamentoDTO));
    }

    @DeleteMapping(value = "/excluir")
    public ResponseEntity<String> deletarTreinamento(@RequestBody TreinamentoDTO treinamentoDTO) throws Exception{
        this.treinamentoService.excluirTreinamento(treinamentoDTO);
        return ResponseEntity.ok("Treinamento excluído com sucesso");
    }
}
