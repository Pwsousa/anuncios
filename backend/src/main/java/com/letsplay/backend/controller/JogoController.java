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
import org.springframework.web.bind.annotation.RestController;

import com.letsplay.backend.entity.Jogo;
import com.letsplay.backend.service.JogoService;


@RestController
@RequestMapping("/api/Jogo")
public class JogoController {
    
    @Autowired
    private JogoService jogoService;
    
    @GetMapping("/")
    private List<Jogo> buscarTodos(){
        return jogoService.buscarTodos();
    }

    @PostMapping("/")
    private Jogo inserir(@RequestBody Jogo jogo){
        return jogoService.inserir(jogo);
    }    

    @PutMapping("/")
    public Jogo alterar(@RequestBody Jogo jogo){
        return jogoService.alterar(jogo);
    }

    @DeleteMapping("/{id}")   
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        jogoService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")   
    public ResponseEntity<Jogo> buscarPorId(@PathVariable("id") Long id){
        
        return ResponseEntity.ok(jogoService.buscarPorId(id));
    }
}
