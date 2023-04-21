package br.com.bentinho.mercadinho.Controller;

import br.com.bentinho.mercadinho.entity.Carrinho;
import br.com.bentinho.mercadinho.repository.CarrinhoRepository;
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

    @PostMapping
    public Carrinho criar(Carrinho carrinho){
        return carrinhoService.save(carrinho);
    }

    @GetMapping("/{id}")
    public Optional<Carrinho> listagem(@PathVariable Long id){
        return carrinhoRepository.findById(id);
    }

}
