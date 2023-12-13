package com.letsplay.backend.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letsplay.backend.dto.PessoaClienteRequestDTO;
import com.letsplay.backend.entity.Pessoa;
import com.letsplay.backend.repository.PessoaRepository;

@Service
public class PessoaClienteService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PermissaoPessoaService permissaoPessoaService;

    @Autowired
    private EmailService emailService;

    public Pessoa registrar(PessoaClienteRequestDTO pessoaClienteRequestDTO){
        Pessoa pessoa = new PessoaClienteRequestDTO().Converter(pessoaClienteRequestDTO);
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNovo = pessoaRepository.saveAndFlush(pessoa);
        permissaoPessoaService.vincularPessoaPermissaoCliente(pessoaNovo);
        emailService.enviarEmailTexto(pessoaNovo.getEmail(), "Cadastro no site Let's play", "O registro no website foi realizado com sucesso, embreve você receberá a senha de acesso por email");
        return pessoaNovo;

        /*
        Map<String, Object> propriedades = new HashMap<>();
        propriedades.put("nome", pessoaNovo.getNome());
        propriedades.put("messagem", "O registro no website foi realizado com sucesso, embreve você receberá a senha de acesso por email");
        emailService.enviarEmailTemplate(pessoaNovo.getEmail(), "Cadastro no site Let's play", propriedades);
        
        */
        
        
    }


}
