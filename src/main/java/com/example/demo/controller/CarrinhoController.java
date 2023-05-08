package com.example.demo.controller;

import com.example.demo.entidades.Carrinho;
import com.example.demo.entidades.Comprador;
import com.example.demo.entidades.Produto;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.CompradorRepository;
import com.example.demo.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    
    private CarrinhoRepository carrinhoRepository;


    private final CompradorRepository compradorRepository;

    private final ProdutoRepository produtoRepository;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrinho criar(@RequestBody Carrinho carrinho){

        Comprador comprador = carrinho.getComprador();
        if (comprador.getId() != null) { // Verifica se a entidade Comprador já possui ID atribuído
            comprador = compradorRepository.findById(comprador.getId()).orElse(null); // Recupera a entidade Comprador do banco de dados
        }
        carrinho.setComprador(comprador); // Associa a entidade Comprador com Carrinho

        Produto produto = carrinho.getProduto();

        if(produto.getId() != null){
            produto = produtoRepository.findById(produto.getId()).orElse(null);

        }

        carrinho.setProduto(produto);

        assert produto != null;
        Double valorTotal = produto.getValorUnitario()*produto.getQuantidade();

        carrinho.setValorTotal(valorTotal);

        return carrinhoRepository.save(carrinho);



    }

    @GetMapping("/{id}")
    public Optional<Carrinho> exibeporId(@PathVariable Long id){

        return carrinhoRepository.findById(id);
    }

}
