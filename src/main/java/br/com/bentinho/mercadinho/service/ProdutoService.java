package br.com.bentinho.mercadinho.service;

import br.com.bentinho.mercadinho.entity.Produto;
import br.com.bentinho.mercadinho.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto save(Produto produto){
        return repository.save(produto);
    }


}
