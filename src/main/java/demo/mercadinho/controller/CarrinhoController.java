package demo.mercadinho.controller;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.repository.CarrinhoRepository;
import demo.mercadinho.service.CarrinhoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    private CarrinhoService carrinhoService;


    private CarrinhoRepository carrinhoRepository;

    @PostMapping
    public ResponseEntity<Carrinho> criar(@RequestBody Carrinho carrinho){

        return ResponseEntity.ok().body(carrinhoService.criar(carrinho));

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Carrinho>> exibir(@PathVariable Long id){
        return ResponseEntity.ok().body(carrinhoRepository.findById(id));
    }

}
