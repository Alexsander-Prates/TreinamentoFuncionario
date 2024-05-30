package com.alexdevprates.backendstatustreinamentos.controller;

import com.alexdevprates.backendstatustreinamentos.dto.FuncionarioDTO;
import com.alexdevprates.backendstatustreinamentos.service.FuncionarioService;
import com.alexdevprates.backendstatustreinamentos.utils.MensagensReponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

    @GetMapping
    public ResponseEntity<?> listaFuncionarios() throws Exception {
        List<FuncionarioDTO> usuarios = funcionarioService.listaDeFuncionarios();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionario(@PathVariable("id") Long id) throws Exception {
        FuncionarioDTO funcionarioDTO = this.funcionarioService.buscarFuncionarioPorId(id);
        return ResponseEntity.ok(funcionarioDTO);
    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity<?> cadastrarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) throws Exception {
        this.funcionarioService.inserirFuncionario(funcionarioDTO);
        return ResponseEntity.ok(MensagensReponseEntity.FUNCIONARIO_CADASTRADO_SUCESSO);
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<FuncionarioDTO> alterarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) throws Exception {
        this.funcionarioService.alterarUsuario(funcionarioDTO);
        return ResponseEntity.ok(funcionarioDTO);
    }

    @DeleteMapping(value = "/excluir") //500 VERIFICAR
    public ResponseEntity<String> deletarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) throws Exception {
        this.funcionarioService.excluirUsuario(funcionarioDTO);
        return ResponseEntity.ok(MensagensReponseEntity.FUNCIONARIO_DELETADO_SUCESSO);
    }


}
