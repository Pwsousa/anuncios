package com.letsplay.backend.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;


@Entity
@Table(name = "pessoa")
@Data
public class Pessoa {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String email;
    private String Senha;


    @ManyToOne
    @JoinColumn(name = "Cidade_id")
    private Cidade cidade;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;    
}
