package com.alexdevprates.backendstatustreinamentos.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
//class de validacao de corrente de filtros ao usuario
public class SecurityConfiguration  {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();

    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.GET, "/funcionario/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/funcionario/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/funcionario/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/funcionario/**").hasRole("ADMIN")

                        // Permissões para /funcionariotreinamento endpoints
                        .requestMatchers(HttpMethod.GET, "/funcionariotreinamento/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/funcionariotreinamento/**").hasRole("ADMIN")

                        // Permissões para /treinamento endpoints
                        .requestMatchers(HttpMethod.GET, "/treinamento/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.POST, "/treinamento/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/treinamento/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/treinamento/**").hasRole("ADMIN")

                        .requestMatchers(HttpMethod.POST,"/autenticacao/login").permitAll()
                        .requestMatchers(HttpMethod.POST,"/autenticacao/registrar").permitAll()


                        // Qualquer outra requisição precisa estar autenticada
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
