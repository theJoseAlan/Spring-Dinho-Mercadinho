package com.example.demo.service;

import com.example.demo.entidades.Carrinho;
import com.example.demo.repository.CarrinhoRepository;
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
