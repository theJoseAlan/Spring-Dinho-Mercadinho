package com.example.demo.controller;

import com.example.demo.entidades.Comprador;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.CompradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoa")
public class CompradorController {

    private CompradorService compradorService;

    private PessoaRepository pessoaRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comprador criar(@RequestBody Comprador comprador){
       return compradorService.salvar(comprador);
    }

    @GetMapping("/exibir")
    public List<Comprador> exibir(){
        return pessoaRepository.findAll();
    }


}
