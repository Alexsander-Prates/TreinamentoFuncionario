package com.alexdevprates.backendstatustreinamentos.service;

import com.alexdevprates.backendstatustreinamentos.dto.FuncionarioDTO;
import com.alexdevprates.backendstatustreinamentos.entity.FuncionarioEntity;
import com.alexdevprates.backendstatustreinamentos.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> listaDeFuncionarios() throws Exception {

        List<FuncionarioEntity> funcionarioEntity = this.funcionarioRepository.findAll();
        if(funcionarioEntity.isEmpty()){

            throw new Exception("Nenhum funcionário cadastrado");
        }else{

            return funcionarioEntity.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
        }

    }

    public FuncionarioDTO buscarFuncionarioPorId(Long id) throws Exception {

        if(id!=null && this.funcionarioRepository.existsById(id)){
            FuncionarioEntity funcionarioEntity = (this.funcionarioRepository.findById(id).get());
            return new FuncionarioDTO(funcionarioEntity);
        } else{

            throw new Exception("Funcionário não localizado");
        }

    }

    public void inserirFuncionario(FuncionarioDTO funcionarioDTO) throws Exception {
        if(funcionarioDTO !=null){
            FuncionarioEntity funcionarioEntity = new FuncionarioEntity(funcionarioDTO);
            this.funcionarioRepository.save(funcionarioEntity);
        } else{
            throw new Exception("Funcionário inválido");
        }
    }


    public FuncionarioDTO alterarUsuario(FuncionarioDTO funcionarioDTO) throws Exception {
        if(funcionarioDTO !=null && this.funcionarioRepository.existsById(funcionarioDTO.getId())){
            FuncionarioEntity funcionarioEntity = new FuncionarioEntity(funcionarioDTO);
            return new FuncionarioDTO(this.funcionarioRepository.save(funcionarioEntity));
        }else {
            throw new Exception("Usuário inválido");
        }
    }

    public void excluirUsuario(Long id) throws Exception {
        if(id !=null && this.funcionarioRepository.existsById(id)){
            FuncionarioEntity funcionarioEntity = this.funcionarioRepository.findById(id).get();
            this.funcionarioRepository.delete(funcionarioEntity);
        } else {
            throw new Exception("Usuário não encontrado");
        }
    }
}
