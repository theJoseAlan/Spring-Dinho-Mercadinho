package demo.mercadinho.service;

import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@AllArgsConstructor
@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Transactional
    public Produto save(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto buscar(Long produtoId){
        return produtoRepository.findById(produtoId).orElseThrow();
    }

    public List<Produto> listaProdutos(){
        return produtoRepository.findAll();
    }
}
