package demo.mercadinho.controller;

import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.ProdutoRepository;
import demo.mercadinho.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<Produto> adcionar(@RequestBody Produto produto){

        Double valorTotal = produto.getValorUnitario()* produto.getQuantidade();

        produto.setValorTotal(valorTotal);

        Produto produtoSalvo = produtoService.save(produto);

        // Cria a URI do recurso criado
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(produtoSalvo.getId())
                .toUri();

        // Retorna a resposta com o status "Created" e a URI do recurso criado
        return ResponseEntity.created(uri).body(produtoSalvo);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> exibe(@PathVariable Long id){

        return ResponseEntity.ok().body(produtoRepository.findById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        produtoService.deletaProduto(id);

        return ResponseEntity.noContent().build();
    }

}
