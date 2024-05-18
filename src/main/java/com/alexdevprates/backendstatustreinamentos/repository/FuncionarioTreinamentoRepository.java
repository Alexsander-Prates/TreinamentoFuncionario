package com.alexdevprates.backendstatustreinamentos.repository;

import com.alexdevprates.backendstatustreinamentos.entity.FuncionarioTreinamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioTreinamentoRepository extends JpaRepository<FuncionarioTreinamentoEntity, Long> {


}
