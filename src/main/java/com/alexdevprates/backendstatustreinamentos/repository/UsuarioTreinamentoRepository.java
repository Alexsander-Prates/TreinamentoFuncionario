package com.alexdevprates.backendstatustreinamentos.repository;

import com.alexdevprates.backendstatustreinamentos.entity.UsuarioTreinamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioTreinamentoRepository extends JpaRepository<UsuarioTreinamentoEntity, Long> {


}
