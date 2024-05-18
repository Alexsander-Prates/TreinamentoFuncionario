package com.alexdevprates.backendstatustreinamentos.dto;

import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import com.alexdevprates.backendstatustreinamentos.entity.UsuarioEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class UsuarioTreinamentoDTO {


    public UsuarioTreinamentoDTO(Long id, UsuarioEntity usuarioEntity, TreinamentoEntity treinamentoEntity) {
        this.id = id;

        this.usuarioDTO = new UsuarioDTO();
        this.usuarioDTO.setId(usuarioEntity.getId());


        this.treinamentoDTO = new TreinamentoDTO();
        this.treinamentoDTO.setId(treinamentoEntity.getId());

    }




    private Long id;
    private UsuarioDTO usuarioDTO;
    private TreinamentoDTO treinamentoDTO;
}
