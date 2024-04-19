package com.alexdevprates.backendstatustreinamentos.entity;

import com.alexdevprates.backendstatustreinamentos.dto.TreinamentoDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

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

    private String descricao;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fim;

}