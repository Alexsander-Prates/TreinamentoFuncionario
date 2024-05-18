package com.alexdevprates.backendstatustreinamentos.dto;

import com.alexdevprates.backendstatustreinamentos.entity.FuncionarioEntity;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.springframework.beans.BeanUtils;

@Data
public class FuncionarioDTO {

    public FuncionarioDTO(){

    }

    public FuncionarioDTO(FuncionarioEntity funcionarioEntity){
        BeanUtils.copyProperties(funcionarioEntity, this);
    }

    private Long id;

    @NotBlank(message = "Nome é obrigatório")
    @Size(min=2,max=50)
    @Pattern(regexp = "^[A-Z]+(.)*")
    private String nome;

    @NotNull(message = "Setor é obrigatório")
    @NotBlank(message = "Setor é obrigatório")
    private String setor;

    @NotNull(message = "Cargo é obrigatório")
    @NotBlank(message = "Cargo é obrigatório")
    private String cargo;

    private String inscricao;
}
