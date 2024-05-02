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
        // Copiar outras propriedades de UsuarioEntity para UsuarioDTO

        this.treinamentoDTO = new TreinamentoDTO();
        this.treinamentoDTO.setId(treinamentoEntity.getId());
        // Copiar outras propriedades de TreinamentoEntity para TreinamentoDTO
    }




    private Long id;
    private UsuarioDTO usuarioDTO;
    private TreinamentoDTO treinamentoDTO;
}
