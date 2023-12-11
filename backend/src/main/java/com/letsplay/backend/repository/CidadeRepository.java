package com.letsplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsplay.backend.entity.Cidade;


public interface CidadeRepository extends JpaRepository<Cidade,Long>{

        
}