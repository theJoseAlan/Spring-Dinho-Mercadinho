package com.example.demo.service;

import com.example.demo.entidades.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProdutoServiceTest {

    @Mock
    private ProdutoRepository produtoRepository;

    private Produto produto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        startProduto();
    }

    @Test
    @DisplayName("Save sucess")
    void save() {
        when(produtoRepository.save(any())).thenReturn(produto);

        Produto response = produtoRepository.save(produto);

        assertNotNull(produto);
        assertEquals(Produto.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals("Bala", response.getNome());
        assertEquals(0.5, response.getValorUnitario());
        assertEquals(10, response.getQuantidade());

        assertEquals(5, response.getQuantidade()*response.getValorUnitario());

    }

    @Test
    @DisplayName("Save error")
    void saveError(){

    }

    private void startProduto(){
        produto = new Produto(1L, "Bala", 0.5, 10);
    }
}