package com.alexdevprates.backendstatustreinamentos.service;

import com.alexdevprates.backendstatustreinamentos.dto.TreinamentoDTO;
import com.alexdevprates.backendstatustreinamentos.dto.UsuarioDTO;
import com.alexdevprates.backendstatustreinamentos.dto.UsuarioTreinamentoDTO;
import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import com.alexdevprates.backendstatustreinamentos.entity.UsuarioEntity;
import com.alexdevprates.backendstatustreinamentos.entity.UsuarioTreinamentoEntity;
import com.alexdevprates.backendstatustreinamentos.repository.TreinamentoRepository;
import com.alexdevprates.backendstatustreinamentos.repository.UsuarioRepository;
import com.alexdevprates.backendstatustreinamentos.repository.UsuarioTreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioTreinamentoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    @Autowired
    private UsuarioTreinamentoRepository usuarioTreinamentoRepository;

    public void associarTreinamento(UsuarioTreinamentoDTO usuarioTreinamentoDTO) throws Exception{
        if(usuarioTreinamentoDTO!=null){
            UsuarioEntity usuarioEntity = this.usuarioRepository.getReferenceById(usuarioTreinamentoDTO.getUsuarioDTO().getId());
            TreinamentoEntity treinamentoEntity = this.treinamentoRepository.getReferenceById(usuarioTreinamentoDTO.getTreinamentoDTO().getId());

            UsuarioTreinamentoEntity usuarioTreinamentoEntity = new UsuarioTreinamentoEntity(usuarioEntity,treinamentoEntity);
            this.usuarioTreinamentoRepository.save(usuarioTreinamentoEntity);
        } else{
            throw new Exception("Erro ao associar");
        }
    }

    public List<UsuarioTreinamentoDTO> listaTreinamentosVinculados() {
        List<UsuarioTreinamentoEntity> usuarioTreinamentoEntities = this.usuarioTreinamentoRepository.findAll();
        return usuarioTreinamentoEntities.stream()
                .map(usuarioTreinamentoEntity -> new UsuarioTreinamentoDTO(usuarioTreinamentoEntity.getId(), usuarioTreinamentoEntity.getUsuarioEntity(), usuarioTreinamentoEntity.getTreinamentoEntity()))
                .collect(Collectors.toList());
    }
}
