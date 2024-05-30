package com.alexdevprates.backendstatustreinamentos.repository;

import com.alexdevprates.backendstatustreinamentos.entity.UsuarioEntity;
import com.alexdevprates.backendstatustreinamentos.entity.utils.UsuarioTipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {

    UsuarioEntity findByLogin(String login);
}
