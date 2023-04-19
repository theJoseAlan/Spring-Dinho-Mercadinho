package br.com.bentinho.mercadinho.Controller;

import br.com.bentinho.mercadinho.entity.Produto;
import br.com.bentinho.mercadinho.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    
    private ProdutoService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Produto adicionar(@RequestBody Produto produto) {
        return service.save(produto);
    }

}