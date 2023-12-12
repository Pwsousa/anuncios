package com.letsplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.letsplay.backend.entity.Permissao;
import java.util.List;


public interface PermissaoRepository extends JpaRepository<Permissao,Long>{
    
    List<Permissao> findByNome(String nome);
}
