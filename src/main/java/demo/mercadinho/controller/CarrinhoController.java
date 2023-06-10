package demo.mercadinho.controller;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.dto.CarrinhoDto;
import demo.mercadinho.mapper.CarrinhoMapper;
import demo.mercadinho.repository.CarrinhoRepository;
import demo.mercadinho.service.CarrinhoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
    public ResponseEntity<Optional<Object>> exibir(@PathVariable Long id){

        Optional<Carrinho> carrinho = null;
        carrinho= carrinhoService.buscarPorId(id);


        CarrinhoDto carrinhoDto = CarrinhoMapper.carrinhoToCarrinhoDto(carrinho.get());

        return ResponseEntity.ok().body(Optional.of(carrinhoDto));
    }

    @GetMapping
    public ResponseEntity<List<Carrinho>> exibirTodos(){
        return ResponseEntity.ok().body(carrinhoService.listAll());
    }

}
