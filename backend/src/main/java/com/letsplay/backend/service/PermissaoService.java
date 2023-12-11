package com.letsplay.backend.service;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsplay.backend.entity.Permissao;
import com.letsplay.backend.repository.PermissaoRepository;

@Service
public class PermissaoService {
    
    @Autowired
    private PermissaoRepository permissaoRepository;

    public List<Permissao> buscarTodos(){
        return permissaoRepository.findAll();
    }

    public Permissao inserir (Permissao permissao){
        permissao.setDataCriacao(new Date());
        Permissao permissaoNova = permissaoRepository.saveAndFlush(permissao);
        return permissaoNova;
    }

    public Permissao alterar(Permissao permissao){
        permissao.setDataAtualizacao(new Date());
        return permissaoRepository.saveAndFlush(permissao);
    }

    public void excluir(Long id){
        Permissao permissao = permissaoRepository.findById(id).get();
        permissaoRepository.delete(permissao);
    }

    public Permissao buscarPorId(Long id){
        return permissaoRepository.findById(id).get();
    }
}
