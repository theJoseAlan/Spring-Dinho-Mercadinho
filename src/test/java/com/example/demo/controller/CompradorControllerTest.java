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

import java.util.List;
import java.util.Optional;

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
    @DisplayName("Find All sucess")
    void exibir() {
        when(compradorRepository.findAll()).thenReturn(List.of(comprador));

        ResponseEntity<List<Comprador>> response = compradorController.exibir();

        assertNotNull(response);
        assertNotNull(response.getBody());

        //Verificando se o primeiro objeto da lista é uma instância da classe Comprador
        assertEquals(Comprador.class, response.getBody().get(0).getClass());

        //Já que se trata de uma lista, é necessário verificar os atributos
        //do objeto pelo indice associado a ele
        assertEquals(ID, response.getBody().get(0).getId());
        assertEquals(NOME, response.getBody().get(0).getNome());
        assertEquals(CPF, response.getBody().get(0).getCpf());
        assertEquals(TELEFONE, response.getBody().get(0).getTelefone());
        assertEquals(ENDERECO, response.getBody().get(0).getEndereco());

    }

    @Test
    @DisplayName("FindById sucess")
    void exibeporId() {
        when(compradorRepository.findById(any())).thenReturn(Optional.ofNullable(comprador));

        ResponseEntity<Comprador> response = compradorController.exibeporId(ID);

        //Validações
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());

        assertEquals(Comprador.class, response.getBody().getClass());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NOME, response.getBody().getNome());
        assertEquals(CPF, response.getBody().getCpf());
        assertEquals(ENDERECO, response.getBody().getEndereco());
        assertEquals(TELEFONE, response.getBody().getTelefone());

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