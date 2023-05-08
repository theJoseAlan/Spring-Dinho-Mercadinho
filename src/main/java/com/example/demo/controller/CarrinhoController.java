package com.example.demo.controller;

import com.example.demo.entidades.Carrinho;
import com.example.demo.entidades.Produto;
import com.example.demo.entidades.Comprador;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.repository.PessoaRepository;
import com.example.demo.service.CarrinhoService;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/casa")
public class CarrinhoController {

    private CarrinhoService carrinhoService;

    private CarrinhoRepository carrinhoRepository;

    private EntityManager entityManager;
    private final PessoaRepository pessoaRepository;

    private final ProdutoRepository produtoRepository;

    @Transactional
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrinho criar(@RequestBody Carrinho carrinho){

        Comprador comprador = carrinho.getComprador();
        if (comprador.getId() != null) { // Verifica se a entidade Comprador já possui ID atribuído
            comprador = pessoaRepository.findById(comprador.getId()).orElse(null); // Recupera a entidade Comprador do banco de dados
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



    @GetMapping("/exibe")
    public List<Carrinho> casaList(){

        return carrinhoRepository.findAll();
    }

}
