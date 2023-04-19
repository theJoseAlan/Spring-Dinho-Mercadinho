package br.com.bentinho.mercadinho.Controller;

import br.com.bentinho.mercadinho.entity.Carrinho;
import br.com.bentinho.mercadinho.repository.CarrinhoRepository;
import br.com.bentinho.mercadinho.service.CarrinhoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;

    private CarrinhoRepository carrinhoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carrinho criar(Carrinho carrinho){
        return carrinhoService.salvar(carrinho);
    }

    @GetMapping("/{id}")
    public Optional<Carrinho> exibir(@PathVariable Long id){
        return carrinhoRepository.findById(id);
    }

}
