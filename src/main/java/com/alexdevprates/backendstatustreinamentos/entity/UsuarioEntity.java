package com.alexdevprates.backendstatustreinamentos.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.alexdevprates.backendstatustreinamentos.dto.UsuarioDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name="USUARIO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioEntity{

    public UsuarioEntity(UsuarioDTO usuarioDTO){
        BeanUtils.copyProperties(usuarioDTO,this);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String setor;

    @Column(nullable = false)
    private String cargo;

    @Column(nullable = false)
    private String inscricao;


    @ManyToMany
    @JoinTable(
            name = "USUARIO_TREINAMENTO", // Nome da tabela de associação
            joinColumns = @JoinColumn(name = "usuario_id"), // Nome da coluna que referencia o ID do usuário
            inverseJoinColumns = @JoinColumn(name = "treinamento_id") // Nome da coluna que referencia o ID do treinamento
    )
    private List<TreinamentoEntity> treinamentos = new ArrayList<>();


     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }




}