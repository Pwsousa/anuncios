package com.letsplay.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.letsplay.backend.entity.Jogo;

public interface JogoRepository extends JpaRepository<Jogo,Long>{
    
}
