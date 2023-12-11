package com.letsplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsplay.backend.entity.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao,Long>{
    
}
