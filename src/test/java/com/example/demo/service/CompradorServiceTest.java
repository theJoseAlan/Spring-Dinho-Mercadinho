package com.example.demo.service;

import com.example.demo.entidades.Comprador;
import com.example.demo.repository.CompradorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CompradorServiceTest {

    @Mock
    @Autowired
    private CompradorRepository compradorRepository;

    @Mock
    private CompradorService compradorService;

    private Comprador comprador;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        startComprador();
    }


    @Test
    @DisplayName("Save sucess")
    void salvar() {

        when(compradorService.salvar(any())).thenReturn(comprador);

        Comprador response = compradorService.salvar(comprador);

        //assertNotNull(response);
        assertEquals(Comprador.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals("Ana", response.getNome());
        assertEquals("040320", response.getCpf());
        assertEquals("Endereco", response.getEndereco());
        assertEquals("12345", response.getTelefone());



    }

    private void startComprador(){

        comprador = new Comprador(1L, "Ana", "040320", "Endereco", "12345");

    }


}