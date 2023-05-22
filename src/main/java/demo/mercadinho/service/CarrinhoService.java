package demo.mercadinho.service;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.CarrinhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    private CompradorService compradorService;

    private ProdutoService produtoService;

    @Transactional
    public Carrinho criar(Carrinho carrinho){
        Comprador comprador = compradorService.buscar(carrinho.getComprador().getId());

        Produto produto = produtoService.buscar(carrinho.getProduto().getId());

        carrinho.setComprador(comprador);
        carrinho.setProduto(produto);
        return carrinhoRepository.save(carrinho);
    }

}
