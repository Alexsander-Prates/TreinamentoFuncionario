package com.alexdevprates.backendstatustreinamentos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import com.alexdevprates.backendstatustreinamentos.entity.utils.UsuarioTipo;


@Data
public class UsuarioDTO {

    private int id;

    @NotBlank(message = "Login é obrigatório")
    @Size(min=3,max=15)
    private String login;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min=6,max=50)
    @Pattern(regexp = "^[A-Z]+(.)*") //1ªLetra maiuscula
    private String senha;

    private UsuarioTipo tipo;

}
