package com.alexdevprates.backendstatustreinamentos.dto;

import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class TreinamentoDTO {

    public TreinamentoDTO(){

    }

    public TreinamentoDTO(TreinamentoEntity treinamentoEntity){
        BeanUtils.copyProperties(treinamentoEntity, this);
    }

    private Long id;

    private String nome;

    private String descricao;

    private LocalDateTime inicio;

    private LocalDateTime fim;
}
