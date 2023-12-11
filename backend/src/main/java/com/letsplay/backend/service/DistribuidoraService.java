package com.letsplay.backend.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsplay.backend.entity.Distribuidora;
import com.letsplay.backend.repository.DistribuidoraRepository;

@Service
public class DistribuidoraService {
    
    @Autowired
    private DistribuidoraRepository distribuidoraRepository;

    public List<Distribuidora> buscarTodos(){
        return distribuidoraRepository.findAll();
    }

    public Distribuidora inserir (Distribuidora distribuidora){
        distribuidora.setDataCriacao(new Date());
        Distribuidora distribuidoraNova = distribuidoraRepository.saveAndFlush(distribuidora);
        return distribuidoraNova;
    }

    public Distribuidora alterar(Distribuidora distribuidora){
        distribuidora.setDataAtualizacao(new Date());
        return distribuidoraRepository.saveAndFlush(distribuidora);
    }

    public void excluir(Long id){
        Distribuidora distribuidora = distribuidoraRepository.findById(id).get();
        distribuidoraRepository.delete(distribuidora);
    }

    public Distribuidora buscarPorId(Long id){
        return distribuidoraRepository.findById(id).get();
    }
}
