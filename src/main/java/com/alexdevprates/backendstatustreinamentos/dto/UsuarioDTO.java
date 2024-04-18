package com.alexdevprates.backendstatustreinamentos.dto;

import com.alexdevprates.backendstatustreinamentos.entity.UsuarioEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UsuarioDTO {

    public UsuarioDTO(){

    }

    public UsuarioDTO(UsuarioEntity usuarioEntity){
        BeanUtils.copyProperties(usuarioEntity, this);
    }

    private Long id;

    private String nome;

    private String email;

    private String senha;

    private String setor;

    private String cargo;

}
