package demo.mercadinho.service;

import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;


    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }
}
