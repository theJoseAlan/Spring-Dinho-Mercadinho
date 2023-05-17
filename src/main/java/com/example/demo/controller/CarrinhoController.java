package com.example.demo.controller;

import com.example.demo.entidades.Carrinho;
import com.example.demo.entidades.Comprador;
import com.example.demo.entidades.Produto;
import com.example.demo.model.StatusCompra;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.CompradorRepository;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.CarrinhoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    
    private CarrinhoRepository carrinhoRepository;


    private final CompradorRepository compradorRepository;

    private final ProdutoRepository produtoRepository;

    private CarrinhoService carrinhoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Carrinho> criar(@RequestBody Carrinho carrinho){

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

        carrinho.setStatusCompra(StatusCompra.FINALIZADA);

        Carrinho carrinhoSalvo = carrinhoService.save(carrinho);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(carrinhoSalvo.getId())
                .toUri();
        
        return ResponseEntity.created(uri).body(carrinhoSalvo);

    }

    @GetMapping("/{id}")
    public Optional<Carrinho> exibeporId(@PathVariable Long id){

        return carrinhoRepository.findById(id);
    }

}
