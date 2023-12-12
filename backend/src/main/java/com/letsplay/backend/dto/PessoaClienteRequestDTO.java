package com.letsplay.backend.dto;

import org.springframework.beans.BeanUtils;

import com.letsplay.backend.entity.Pessoa;

import lombok.Data;

@Data
public class PessoaClienteRequestDTO {
    
    private String nome;
    private String email;


    public Pessoa Converter(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new Pessoa();
        BeanUtils.copyProperties(pessoaClienteRequestDTO, pessoa);
        return pessoa;
    }   
}
