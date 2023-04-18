package br.com.bentinho.mercadinho.Controller;

import br.com.bentinho.mercadinho.domain.Comprador;
import br.com.bentinho.mercadinho.repository.CompradorRepository;
import br.com.bentinho.mercadinho.service.CompradorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/comprador")
public class CompradorController {

    private CompradorService compradorService;


    private CompradorRepository compradorRepository;

    @PersistenceContext
    private EntityManager manager;

    private CompradorService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comprador adicionar(@RequestBody Comprador comprador) {
        return compradorService.salvar(comprador);
    }

    @GetMapping("/listar")
    public List<Comprador> listar(){
        return compradorRepository.findAll();
    }

}