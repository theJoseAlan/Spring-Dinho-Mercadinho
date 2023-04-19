package br.com.bentinho.mercadinho.service;

import br.com.bentinho.mercadinho.entity.Comprador;
import br.com.bentinho.mercadinho.repository.CompradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompradorService {

    @Autowired
    private CompradorRepository repository;

    public Comprador salvar(Comprador comprador){
        return repository.save(comprador);
    }



}
