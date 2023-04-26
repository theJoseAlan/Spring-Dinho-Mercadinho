package com.example.demo.controller;

import com.example.demo.entidades.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/cidade")
public class ProdutoController {

    private ProdutoService cidadeService;

    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto adcionar(@RequestBody Produto produto){
        return cidadeService.save(produto);
    }

    @GetMapping("/{id}")
    public Optional<Produto> exibe(@PathVariable Long id){
        return produtoRepository.findById(id);
    }

}
