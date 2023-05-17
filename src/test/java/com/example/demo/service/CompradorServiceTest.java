package com.example.demo.service;

import com.example.demo.entidades.Comprador;
import com.example.demo.repository.CompradorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class CompradorServiceTest {

    public static final long ID = 1L;
    public static final String NOME = "Ana";
    public static final String CPF = "040320";
    public static final String ENDERECO = "Endereco";
    public static final String TELEFONE = "12345";


    @Mock
    private CompradorRepository compradorRepository;

    @InjectMocks
    private CompradorService compradorService;

    private Comprador comprador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startComprador();
    }


    @Test
    void testSalvar() {

        when(compradorRepository.save(comprador)).thenReturn(comprador);


        Comprador resultado = compradorService.salvar(comprador);


        assertEquals(comprador, resultado);

    }

    private void startComprador(){

        comprador = new Comprador(ID, NOME, CPF, ENDERECO, TELEFONE);

    }


}