package com.alexdevprates.backendstatustreinamentos.entity;

import com.alexdevprates.backendstatustreinamentos.dto.TreinamentoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="TREINAMENTO")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TreinamentoEntity{


    public TreinamentoEntity(TreinamentoDTO treinamentoDTO){
        BeanUtils.copyProperties(treinamentoDTO,this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String descricao;

    @Column(nullable = false)
    private String inicio;

    @Column(nullable = false)
    private String fim;

    @Column(nullable = false)
    private String classificacao;

    @ManyToMany(mappedBy = "treinamentos")
    private List<FuncionarioEntity> usuarios = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreinamentoEntity that = (TreinamentoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}