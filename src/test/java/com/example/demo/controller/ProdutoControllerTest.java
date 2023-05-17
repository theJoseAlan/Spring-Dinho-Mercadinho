package com.example.demo.controller;

import com.example.demo.entidades.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProdutoControllerTest {

    public static final long ID = 1L;
    public static final String NOME = "Balinha";
    public static final double VALOR_UNITARIO = 0.10;
    public static final int QUANTIDADE = 20;
    @Mock
    private ProdutoService produtoService;

    @Mock
    @Autowired
    private ProdutoRepository produtoRepository;

    @InjectMocks
    private ProdutoController produtoController;

    private Produto produto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        startProduto();
    }

    @Test
    void adcionar() {
        when(produtoService.save(any())).thenReturn(produto);

        //ResponseEntity
    }

    @Test
    void exibe() {
    }

    private void startProduto(){
        produto = new Produto(ID, NOME, VALOR_UNITARIO, QUANTIDADE);
    }
}