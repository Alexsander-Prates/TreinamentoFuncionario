package com.alexdevprates.backendstatustreinamentos.controller;

import com.alexdevprates.backendstatustreinamentos.dto.UsuarioDTO;
import com.alexdevprates.backendstatustreinamentos.entity.UsuarioEntity;
import com.alexdevprates.backendstatustreinamentos.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("autenticacao")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping("/login")
    public ResponseEntity login (@RequestBody @Valid UsuarioDTO usuarioDto){
        var userNamePassword = new UsernamePasswordAuthenticationToken(usuarioDto.getLogin(),usuarioDto.getSenha());
        var auth = this.authenticationManager.authenticate(userNamePassword); //recebe objeto UsernamePasswordAuthenticationToken
        return ResponseEntity.ok().build();
    }

    @PostMapping("/registrar")
    private ResponseEntity registrarUsuario(@RequestBody @Valid UsuarioDTO usuarioDTO){
        if(this.usuarioRepository.findByLogin(usuarioDTO.getLogin()) !=null) return  ResponseEntity.badRequest().build();

        String encryptadPassword = new BCryptPasswordEncoder().encode(usuarioDTO.getSenha());
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO.getLogin(), encryptadPassword,usuarioDTO.getTipo());
        this.usuarioRepository.save(usuarioEntity);

        return ResponseEntity.ok().build();

    }
}
