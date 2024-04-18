package com.alexdevprates.backendstatustreinamentos.dto;

import com.alexdevprates.backendstatustreinamentos.entity.UsuarioEntity;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Nome é obrigatório")
    @Size(min=2,max=50)
    @Pattern(regexp = "^[A-Z]+(.)*")
    private String nome;

    @NotNull(message = "E-mail é obrigatório")
    @NotBlank(message = "E-mail é obrigatório")
    @Email
    private String email;

    @NotNull(message = "Senha obrigatória")
    @NotBlank(message = "Senha obrigatória")
    @Size(min = 8, max = 20)
    private String senha;

    @NotNull(message = "Setor é obrigatório")
    @NotBlank(message = "Setor é obrigatório")
    private String setor;

    @NotNull(message = "Cargo é obrigatório")
    @NotBlank(message = "Cargo é obrigatório")
    private String cargo;

}
