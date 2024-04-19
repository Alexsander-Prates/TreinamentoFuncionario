package com.alexdevprates.backendstatustreinamentos.service;

import com.alexdevprates.backendstatustreinamentos.dto.UsuarioDTO;
import com.alexdevprates.backendstatustreinamentos.entity.UsuarioEntity;
import com.alexdevprates.backendstatustreinamentos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listaDeUsuario() throws Exception {

        List<UsuarioEntity> usuarioEntity = this.usuarioRepository.findAll();
        if(usuarioEntity.isEmpty()){

            throw new Exception("Nenhum usuário cadastrado");
        }else{

            return usuarioEntity.stream().map(UsuarioDTO::new).collect(Collectors.toList());
        }

    }

    public UsuarioDTO buscarUsuarioPorId(Long id) throws Exception {

        if(id!=null && this.usuarioRepository.existsById(id)){
            UsuarioEntity usuarioEntity = (this.usuarioRepository.findById(id).get());
            return new UsuarioDTO(usuarioEntity);
        } else{

            throw new Exception("Usuario não localizado");
        }

    }

    public void inserirUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if(usuarioDTO!=null){
            UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
            this.usuarioRepository.save(usuarioEntity);
        } else{
            throw new Exception("Usuário inválido");
        }
    }


    public UsuarioDTO alterarUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if(usuarioDTO!=null && this.usuarioRepository.existsById(usuarioDTO.getId())){
            UsuarioEntity usuarioEntity = new UsuarioEntity(usuarioDTO);
            return new UsuarioDTO(this.usuarioRepository.save(usuarioEntity));
        }else {
            throw new Exception("Usuário inválido");
        }
    }

    public void excluirUsuario(UsuarioDTO usuarioDTO) throws Exception {
        if(usuarioDTO!=null && this.usuarioRepository.existsById(usuarioDTO.getId())){
            UsuarioEntity usuarioEntity = this.usuarioRepository.findById(usuarioDTO.getId()).get();
            this.usuarioRepository.delete(usuarioEntity);
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }
}
