package com.alexdevprates.backendstatustreinamentos.entity.utils;

public enum UsuarioTipo {

    ADMINISTRADOR("administrador"),
    TECNICO("tecnico");


    UsuarioTipo(String tipo) {
        this.tipo = tipo;
    }

    private String tipo;

    public String getTipo() {
        return tipo;
    }
}
