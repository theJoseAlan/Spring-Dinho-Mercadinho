package com.example.demo.controller;

import com.example.demo.entidades.Comprador;
import com.example.demo.repository.CompradorRepository;
import com.example.demo.service.CompradorService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/comprador")
public class CompradorController {

    private CompradorService compradorService;

    private CompradorRepository compradorRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Comprador> criar(@RequestBody Comprador comprador){

        Comprador compradornovo = compradorService.salvar(comprador);

       return ResponseEntity.ok(compradornovo);
    }

    @GetMapping("/exibir")
    public List<Comprador> exibir(){
        return compradorRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Comprador> exibeporId(@PathVariable Long id){

        return ResponseEntity.ok().body(compradorRepository.findById(id).get());
    }

    @PutMapping("{id}")
    public Comprador atualizar(@PathVariable Long id, @RequestBody Comprador comprador){

        comprador.setId(id);

        return compradorService.salvar(comprador);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        compradorRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }


}
