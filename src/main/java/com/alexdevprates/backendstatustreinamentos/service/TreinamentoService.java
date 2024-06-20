package com.alexdevprates.backendstatustreinamentos.service;


import com.alexdevprates.backendstatustreinamentos.dto.TreinamentoDTO;
import com.alexdevprates.backendstatustreinamentos.entity.TreinamentoEntity;
import com.alexdevprates.backendstatustreinamentos.repository.TreinamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TreinamentoService {

    @Autowired
    TreinamentoRepository treinamentoRepository;

    public List<TreinamentoDTO> listaTreinamentos() throws Exception {
        List<TreinamentoEntity> treinamentosEntity = this.treinamentoRepository.findAll();
        if(treinamentosEntity.isEmpty()){
            throw new Exception("Sem cadastro");
        } else {
            return treinamentosEntity.stream().map(TreinamentoDTO::new).collect(Collectors.toList());
        }
    }

    public TreinamentoDTO buscarTreinamentoPorId(@RequestBody TreinamentoDTO treinamentoDTO) throws Exception {
        if(treinamentoDTO.getId()!=null && this.treinamentoRepository.existsById(treinamentoDTO.getId())){
            TreinamentoEntity treinamentoEntity = this.treinamentoRepository.getReferenceById(treinamentoDTO.getId());
            return new TreinamentoDTO(treinamentoEntity);
        } else {
            throw new Exception("Treinamento não cadastrado");
        }
    }

    public void cadastrarTreinamento(@RequestBody TreinamentoDTO treinamentoDTO) throws Exception {
        if(treinamentoDTO!=null){

            TreinamentoEntity treinamentoEntity = new TreinamentoEntity(treinamentoDTO);
            this.treinamentoRepository.save(treinamentoEntity);
        } else {
            throw new Exception("Treinamento inválido");
        }
    }


    public TreinamentoDTO alterarTreinamento(@RequestBody TreinamentoDTO treinamentoDTO) throws Exception {
        if (treinamentoDTO.getId() != null && this.treinamentoRepository.existsById(treinamentoDTO.getId())) {
            TreinamentoEntity treinamentoEntity = new TreinamentoEntity(treinamentoDTO);
            return new TreinamentoDTO(this.treinamentoRepository.save(treinamentoEntity));
        } else {
            throw new Exception("Treinamento inválido");
        }

    }

    public void excluirTreinamento(@RequestBody Long id) throws Exception {

        if(id!=null && this.treinamentoRepository.existsById(id)){

            TreinamentoEntity treinamentoEntity = this.treinamentoRepository.findById(id).get();
            this.treinamentoRepository.delete(treinamentoEntity);
        } else {
            throw new Exception("Treinamento inválido");
        }
    }
}
