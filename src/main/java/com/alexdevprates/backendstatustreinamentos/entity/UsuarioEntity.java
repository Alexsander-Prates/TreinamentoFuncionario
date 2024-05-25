package com.alexdevprates.backendstatustreinamentos.entity;

import com.alexdevprates.backendstatustreinamentos.entity.utils.UsuarioTipo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity(name = "usuario")
@Data
@NoArgsConstructor
@Table(name="USUARIO")
public class UsuarioEntity implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UsuarioTipo tipo;

    public UsuarioEntity(String login, String senha, UsuarioTipo tipo) {
        this.login = login;
        this.senha = senha;
        this.tipo = tipo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.tipo == UsuarioTipo.ADMIN) return List.of(
                new SimpleGrantedAuthority("ROLE_ADMIN"),
                new SimpleGrantedAuthority("ROLE_USER"));
    else return List.of(new SimpleGrantedAuthority("ROLE_USER"));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // Alterado para true para indicar que a conta não está expirada
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // Alterado para true para indicar que a conta não está bloqueada
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // Alterado para true para indicar que as credenciais não estão expiradas
    }

    @Override
    public boolean isEnabled() {
        return true; // Alterado para true para indicar que a conta está ativa
    }
}
