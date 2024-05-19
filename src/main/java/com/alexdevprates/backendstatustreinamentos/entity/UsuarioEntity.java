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
@AllArgsConstructor
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

    @Column(nullable = false)
    private UsuarioTipo tipo;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(this.tipo==UsuarioTipo.ADMINISTRADOR) return List.of( new SimpleGrantedAuthority("ROLE_ADMIN"),(new SimpleGrantedAuthority("ROLE_USER")));
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
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
