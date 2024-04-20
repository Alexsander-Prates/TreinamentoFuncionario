package com.alexdevprates.backendstatustreinamentos.controller;

import com.alexdevprates.backendstatustreinamentos.dto.UsuarioDTO;
import com.alexdevprates.backendstatustreinamentos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<?> listaUsuarios() throws Exception {
        List<UsuarioDTO> usuarios = usuarioService.listaDeUsuario();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UsuarioDTO> buscarUsuario(@PathVariable("id") Long id) throws Exception {
        UsuarioDTO usuarioDTO = this.usuarioService.buscarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioDTO);
    }

    @PostMapping(value = "/cadastro")
    public ResponseEntity<?> cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        this.usuarioService.inserirUsuario(usuarioDTO);
        return ResponseEntity.ok("Usuário Cadastrado");
    }

    @PutMapping(value = "/alterar")
    public ResponseEntity<UsuarioDTO> alterarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        this.usuarioService.alterarUsuario(usuarioDTO);
        return ResponseEntity.ok(usuarioDTO);
    }

    @DeleteMapping(value = "/excluir") //500 VERIFICAR
    public ResponseEntity<String> deletarUsuario(@RequestBody UsuarioDTO usuarioDTO) throws Exception {
        this.usuarioService.excluirUsuario(usuarioDTO);
        return ResponseEntity.ok("User Deletado");
    }


}
