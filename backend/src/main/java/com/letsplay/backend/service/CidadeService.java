package com.letsplay.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsplay.backend.entity.Cidade;
import com.letsplay.backend.repository.CidadeRepository;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRespository;


    public List<Cidade> buscarTodos(){
        return cidadeRespository.findAll();
    }

    public Cidade inserir(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNovo = cidadeRespository.saveAndFlush(cidade);
        return cidadeNovo;
    }

    public Cidade alterar(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        return cidadeRespository.saveAndFlush(cidade);
    }

    public void excluir(Long id){
        Cidade Cidade = cidadeRespository.findById(id).get();
        cidadeRespository.delete(Cidade);
    }

    public Cidade buscarPorId(Long id) {
        return cidadeRespository.findById(id).get();
    }

}
