package com.example.demo.controller;

import com.example.demo.entidades.Comprador;
import com.example.demo.repository.CompradorRepository;
import com.example.demo.service.CompradorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CompradorControllerTest {

    public static final long ID = 1L;
    public static final String NOME = "Ana";
    public static final String CPF = "040320";
    public static final String ENDERECO = "Endereco";
    public static final String TELEFONE = "12345";
    private Comprador comprador;

    @Mock
    private CompradorService compradorService;

    @InjectMocks
    private CompradorController compradorController;

    @Mock
    @Autowired
    private CompradorRepository compradorRepository;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        startComprador();
    }

    @Test
    @DisplayName("Create sucess")
    void criar() {
        when(compradorService.salvar(any())).thenReturn(comprador);

        ResponseEntity<Comprador> responseEntity = compradorController.criar(comprador);

        assertNotNull(comprador);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Comprador.class, responseEntity.getBody().getClass());
        assertEquals(ID, responseEntity.getBody().getId());
        assertEquals(NOME, responseEntity.getBody().getNome());
        assertEquals(CPF, responseEntity.getBody().getCpf());
        assertEquals(TELEFONE, responseEntity.getBody().getTelefone());
        assertEquals(ENDERECO, responseEntity.getBody().getEndereco());





    }

    @Test
    void exibir() {
    }

    @Test
    void exibeporId() {
    }

    @Test
    void atualizar() {
    }

    @Test
    void deletar() {
    }


    private void startComprador(){

        comprador = new Comprador(ID, NOME, CPF, ENDERECO, TELEFONE);

    }
}