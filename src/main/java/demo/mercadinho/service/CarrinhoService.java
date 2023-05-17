package demo.mercadinho.service;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.repository.CarrinhoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho save(Carrinho carrinho){

        return carrinhoRepository.save(carrinho);
    }

}
