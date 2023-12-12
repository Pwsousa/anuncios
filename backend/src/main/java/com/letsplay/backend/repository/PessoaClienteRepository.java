package com.letsplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsplay.backend.entity.Pessoa;


public interface PessoaClienteRepository extends JpaRepository<Pessoa,Long>{

        
}