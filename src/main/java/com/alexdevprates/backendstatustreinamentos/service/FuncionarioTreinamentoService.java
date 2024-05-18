package com.alexdevprates.backendstatustreinamentos.service;

import com.alexdevprates.backendstatustreinamentos.dto.FuncionarioTreinamentoDTO;
import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import com.alexdevprates.backendstatustreinamentos.entity.FuncionarioEntity;
import com.alexdevprates.backendstatustreinamentos.entity.FuncionarioTreinamentoEntity;
import com.alexdevprates.backendstatustreinamentos.repository.TreinamentoRepository;
import com.alexdevprates.backendstatustreinamentos.repository.FuncionarioRepository;
import com.alexdevprates.backendstatustreinamentos.repository.FuncionarioTreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioTreinamentoService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private TreinamentoRepository treinamentoRepository;

    @Autowired
    private FuncionarioTreinamentoRepository funcionarioTreinamentoRepository;

    public void associarTreinamento(FuncionarioTreinamentoDTO funcionarioTreinamentoDTO) throws Exception{
        if(funcionarioTreinamentoDTO !=null){
            FuncionarioEntity funcionarioEntity = this.funcionarioRepository.getReferenceById(funcionarioTreinamentoDTO.getFuncionarioDTO().getId());
            TreinamentoEntity treinamentoEntity = this.treinamentoRepository.getReferenceById(funcionarioTreinamentoDTO.getTreinamentoDTO().getId());

            FuncionarioTreinamentoEntity funcionarioTreinamentoEntity = new FuncionarioTreinamentoEntity(funcionarioEntity,treinamentoEntity);
            this.funcionarioTreinamentoRepository.save(funcionarioTreinamentoEntity);
        } else{
            throw new Exception("Erro ao associar");
        }
    }

    public List<FuncionarioTreinamentoDTO> listaTreinamentosVinculados() {
        List<FuncionarioTreinamentoEntity> funcionarioTreinamentoEntities = this.funcionarioTreinamentoRepository.findAll();
        return funcionarioTreinamentoEntities.stream()
                .map(funcionarioTreinamentoEntity -> new FuncionarioTreinamentoDTO(funcionarioTreinamentoEntity.getId(), funcionarioTreinamentoEntity.getFuncionarioEntity(), funcionarioTreinamentoEntity.getTreinamentoEntity()))
                .collect(Collectors.toList());
    }
}
