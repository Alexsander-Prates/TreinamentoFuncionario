package com.alexdevprates.backendstatustreinamentos.repository;

import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinamentoRepository extends JpaRepository<TreinamentoEntity, Long> {

}
