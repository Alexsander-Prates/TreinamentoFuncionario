package com.alexdevprates.backendstatustreinamentos.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.alexdevprates.backendstatustreinamentos.dto.FuncionarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="FUNCIONARIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioEntity {

    public FuncionarioEntity(FuncionarioDTO funcionarioDTO){
        BeanUtils.copyProperties(funcionarioDTO,this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String setor;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String inscricao;


    @ManyToMany
    @JoinTable(
            name = "FUNCIONARIO_TREINAMENTO",
            joinColumns = @JoinColumn(name = "funcionario_id"),
            inverseJoinColumns = @JoinColumn(name = "treinamento_id")
    )
    private List<TreinamentoEntity> treinamentos = new ArrayList<>();


     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FuncionarioEntity that = (FuncionarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }




}