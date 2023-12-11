package com.letsplay.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.letsplay.backend.entity.JogoImagem;

import com.letsplay.backend.service.JogoImagemService;

@RestController
@RequestMapping("/api/JogoImagem")
public class JogoImagemController {
    
    @Autowired
    private JogoImagemService jogoImagemService;
    
    @GetMapping("/")
    private List<JogoImagem> buscarTodos(){
        return jogoImagemService.buscarTodos();
    }

    @PostMapping("/")
    private JogoImagem inserir(@RequestParam("idJogo") Long idJogo, @RequestParam MultipartFile file){
        return jogoImagemService.inserir(idJogo, file);
    }    

    @PutMapping("/")
    public JogoImagem alterar(@RequestBody JogoImagem jogoImagem){
        return jogoImagemService.alterar(jogoImagem);
    }

    @DeleteMapping("/{id}")   
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        jogoImagemService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")   
    public ResponseEntity<JogoImagem> buscarPorId(@PathVariable("id") Long id){
        
        return ResponseEntity.ok(jogoImagemService.buscarPorId(id));
    }
}
