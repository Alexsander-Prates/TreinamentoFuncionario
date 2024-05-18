package com.alexdevprates.backendstatustreinamentos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@Table(name="FUNCIONARIO_TREINAMENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioTreinamentoEntity {

    public FuncionarioTreinamentoEntity(FuncionarioEntity funcionarioEntity, TreinamentoEntity treinamentoEntity) {
        this.funcionarioEntity = funcionarioEntity;
        this.treinamentoEntity = treinamentoEntity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="funcionario_id")
    private FuncionarioEntity funcionarioEntity;

    @ManyToOne
    @JoinColumn(name = "treinamento_id")
    private TreinamentoEntity treinamentoEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioTreinamentoEntity that = (FuncionarioTreinamentoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
