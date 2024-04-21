package com.alexdevprates.backendstatustreinamentos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name="USUARIOTREINAMENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioTreinamentoEntity {

    public UsuarioTreinamentoEntity(UsuarioEntity usuarioEntity, TreinamentoEntity treinamentoEntity) {
        this.usuarioEntity = usuarioEntity;
        this.treinamentoEntity = treinamentoEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private UsuarioEntity usuarioEntity;

    @ManyToOne
    @JoinColumn(name = "treinamento_id")
    private TreinamentoEntity treinamentoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioTreinamentoEntity that = (UsuarioTreinamentoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
