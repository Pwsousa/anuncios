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

import com.letsplay.backend.entity.Distribuidora;

import com.letsplay.backend.service.DistribuidoraService;

@RestController
@RequestMapping("/api/distribuidora")
public class DistribuidoraController {
    
    @Autowired
    private DistribuidoraService distribuidoraService;
    
    @GetMapping("/")
    private List<Distribuidora> buscarTodos(){
        return distribuidoraService.buscarTodos();
    }

    @PostMapping("/")
    private Distribuidora inserir(@RequestBody Distribuidora distribuidora){
        return distribuidoraService.inserir(distribuidora);
    }    

    @PutMapping("/")
    public Distribuidora alterar(@RequestBody Distribuidora distribuidora){
        return distribuidoraService.alterar(distribuidora);
    }

    @DeleteMapping("/{id}")   
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id){
        distribuidoraService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")   
    public ResponseEntity<Distribuidora> buscarPorId(@PathVariable("id") Long id){
        
        return ResponseEntity.ok(distribuidoraService.buscarPorId(id));
    }
}
