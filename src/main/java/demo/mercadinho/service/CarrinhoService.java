package demo.mercadinho.service;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.CarrinhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

        List<Produto> produtos = produtoService.listaProdutos();

        carrinho.setComprador(comprador);
        carrinho.setProdutos(produtos);

        return carrinhoRepository.save(carrinho);
    }

    public Optional<Carrinho> buscarPorId(Long id){
        return carrinhoRepository.findById(id);
    }

    public List<Carrinho> listAll(){
        return carrinhoRepository.findAll();
    }

}
