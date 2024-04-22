package com.alexdevprates.backendstatustreinamentos.dto;

import lombok.Data;

@Data
public class UsuarioTreinamentoDTO {

    private UsuarioDTO usuarioDTO;
    private TreinamentoDTO treinamentoDTO;
}
