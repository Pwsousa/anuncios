package com.letsplay.backend.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.letsplay.backend.entity.Jogo;
import com.letsplay.backend.entity.JogoImagem;
import com.letsplay.backend.repository.JogoImagemRepository;
import com.letsplay.backend.repository.JogoRepository;



@Service
public class JogoImagemService {
    
    @Autowired
    private JogoImagemRepository jogoImagemRepository;

    @Autowired
    private JogoRepository jogoRepository; 


    public List<JogoImagem> buscarTodos(){
        return jogoImagemRepository.findAll();
    }

    public JogoImagem inserir (Long idJogo, MultipartFile file){
        Jogo jogo = jogoRepository.findById(idJogo).get();
        JogoImagem jogoImagemNova = new JogoImagem();

        try {
            if (!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(jogo.getId()) + file.getOriginalFilename();
                Path caminho = Paths
                    .get("C:/Users/pwsou/OneDrive/Documentos/Anuncios/Imagens" + nomeImagem);
                
                    Files.write(caminho,bytes);
                    jogoImagemNova.setNome(nomeImagem);
            
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        jogoImagemNova.setJogo(jogo);
        jogoImagemNova.setDataCriacao(new Date());
        jogoImagemNova = jogoImagemRepository.saveAndFlush(jogoImagemNova);
        return jogoImagemNova;
    }

    public JogoImagem alterar(JogoImagem jogoImagem){
        jogoImagem.setDataCriacao(new Date());
        return jogoImagemRepository.saveAndFlush(jogoImagem);
    }
    public void excluir(Long id){
        JogoImagem jogoImagem = jogoImagemRepository.findById(id).get();
        jogoImagemRepository.delete(jogoImagem);
    }

    public JogoImagem buscarPorId(Long id){
        return jogoImagemRepository.findById(id).get();
    }
}
