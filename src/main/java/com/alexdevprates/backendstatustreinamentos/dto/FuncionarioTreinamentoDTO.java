package com.alexdevprates.backendstatustreinamentos.dto;

import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import com.alexdevprates.backendstatustreinamentos.entity.FuncionarioEntity;
import lombok.Data;

@Data
public class FuncionarioTreinamentoDTO {


    public FuncionarioTreinamentoDTO(Long id, FuncionarioEntity funcionarioEntity, TreinamentoEntity treinamentoEntity) {
        this.id = id;

        this.funcionarioDTO = new FuncionarioDTO();
        this.funcionarioDTO.setId(funcionarioEntity.getId());


        this.treinamentoDTO = new TreinamentoDTO();
        this.treinamentoDTO.setId(treinamentoEntity.getId());

    }




    private Long id;
    private FuncionarioDTO funcionarioDTO;
    private TreinamentoDTO treinamentoDTO;
}
