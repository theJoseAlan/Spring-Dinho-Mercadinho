package demo.mercadinho.service;

import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.repository.CompradorRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Transactional
    public Comprador salvar(Comprador comprador){
        return compradorRepository.save(comprador);
    }

    public Comprador buscar(Long compradorId){
        return compradorRepository.findById(compradorId).orElseThrow();
    }

}