package com.letsplay.backend.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.letsplay.backend.dto.PessoaClienteRequestDTO;
import com.letsplay.backend.entity.Pessoa;
import com.letsplay.backend.service.PessoaClienteService;


@RestController
@RequestMapping("/api/cliente")

public class PessoaClienteController {
    
    @Autowired
    private PessoaClienteService pessoaClienteService;

    @PostMapping("/")
    public Pessoa registrar(@RequestBody PessoaClienteRequestDTO pessoaClienteRequestDTO){
        return pessoaClienteService.registrar(pessoaClienteRequestDTO);
    }


}