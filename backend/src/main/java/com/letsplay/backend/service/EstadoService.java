package com.letsplay.backend.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsplay.backend.entity.Estado;
import com.letsplay.backend.repository.EstadoRespository;

@Service
public class EstadoService {

    @Autowired
    private EstadoRespository estadoRespository;


    public List<Estado> buscarTodos(){
        return estadoRespository.findAll();
    }

    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRespository.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado alterar(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRespository.saveAndFlush(estado);
    }

    public void excluir(Long id){
        Estado estado = estadoRespository.findById(id).get();
        estadoRespository.delete(estado);
    }

    public Estado buscarPorId(Long id) {
        return estadoRespository.findById(id).get();
    }

}
