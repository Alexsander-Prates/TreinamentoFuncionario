package com.alexdevprates.backendstatustreinamentos.dto;

import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Nome é obrigatório")
    @Size(min=2,max=50)
    @Pattern(regexp = "^[A-Z]+(.)*")
    private String nome;

    @NotNull(message = "E-mail é obrigatório")
    @NotBlank(message = "E-mail é obrigatório")
    private String descricao;

    private LocalDateTime inicio;

    private LocalDateTime fim;

    @NotBlank(message = "Classificação é obrigatória")
    private String classificacao;
}
