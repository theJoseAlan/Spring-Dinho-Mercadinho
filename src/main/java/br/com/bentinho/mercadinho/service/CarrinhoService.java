package br.com.bentinho.mercadinho.service;

import br.com.bentinho.mercadinho.entity.Carrinho;
import br.com.bentinho.mercadinho.repository.CarrinhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    public Carrinho save(Carrinho carrinho){
        return carrinhoRepository.save(carrinho);
    }


}
