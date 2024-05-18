package com.alexdevprates.backendstatustreinamentos.repository;

import com.alexdevprates.backendstatustreinamentos.entity.FuncionarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioEntity, Long> {


}
