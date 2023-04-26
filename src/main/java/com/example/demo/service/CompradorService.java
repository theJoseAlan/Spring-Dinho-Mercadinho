package com.example.demo.service;

import com.example.demo.entidades.Comprador;
import com.example.demo.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CompradorService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Comprador salvar(Comprador comprador){
        return pessoaRepository.save(comprador);
    }

}