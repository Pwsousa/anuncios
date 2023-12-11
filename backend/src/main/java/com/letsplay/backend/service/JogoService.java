package com.letsplay.backend.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsplay.backend.entity.Jogo;
import com.letsplay.backend.repository.JogoRepository;


@Service
public class JogoService {
    
    @Autowired
    private JogoRepository jogoRepository;

    public List<Jogo> buscarTodos(){
        return jogoRepository.findAll();
    }

    public Jogo inserir (Jogo jogo){
        jogo.setDataCriacao(new Date());
        Jogo jogoNovo = jogoRepository.saveAndFlush(jogo);
        return jogoNovo;
    }

    public Jogo alterar(Jogo jogo){
        jogo.setDataAtualizacao(new Date());
        return jogoRepository.saveAndFlush(jogo);
    }

    public void excluir(Long id){
        Jogo jogo = jogoRepository.findById(id).get();
        jogoRepository.delete(jogo);
    }

    public Jogo buscarPorId(Long id){
        return jogoRepository.findById(id).get();
    }
}
