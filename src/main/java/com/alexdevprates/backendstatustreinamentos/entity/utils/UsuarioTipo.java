package com.alexdevprates.backendstatustreinamentos.entity.utils;

public enum UsuarioTipo {

    ADMIN("admin"),
    USER("user");

    private String tipo;

    UsuarioTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
