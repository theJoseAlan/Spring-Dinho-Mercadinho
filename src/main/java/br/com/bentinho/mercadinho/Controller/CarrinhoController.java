package br.com.bentinho.mercadinho.Controller;

import br.com.bentinho.mercadinho.entity.Carrinho;
import br.com.bentinho.mercadinho.entity.Comprador;
import br.com.bentinho.mercadinho.repository.CarrinhoRepository;
import br.com.bentinho.mercadinho.repository.CompradorRepository;
import br.com.bentinho.mercadinho.service.CarrinhoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;

    private CarrinhoRepository carrinhoRepository;

    private final CompradorRepository compradorRepository;

    @PostMapping
    public Carrinho criar(@RequestBody Carrinho carrinho){

        Comprador comprador = carrinho.getComprador();
        if (comprador.getId() != null) { // Verifica se a entidade Pessoa já possui ID atribuído
            comprador = compradorRepository.findById(comprador.getId()).orElse(null); // Recupera a entidade Pessoa do banco de dados
        }
        carrinho.setComprador(comprador); // Associa a entidade Pessoa com Casa

        return carrinhoRepository.save(carrinho);

    }

    @GetMapping("/{id}")
    public Optional<Carrinho> listagem(@PathVariable Long id){
        return carrinhoRepository.findById(id);
    }

}
