/*
package com.example.demo.service;

import com.example.demo.entidades.Carrinho;
import com.example.demo.entidades.Comprador;
import com.example.demo.entidades.Produto;
import com.example.demo.repository.CarrinhoRepository;
import com.example.demo.repository.CompradorRepository;
import com.example.demo.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CarrinhoServiceTest {

    @Mock
    private CarrinhoRepository carrinhoRepository;

    @Mock
    private CompradorRepository compradorRepository;

    @Mock
    private ProdutoRepository produtoRepository;

    private Carrinho carrinho;
    private Produto produto;
    private Comprador comprador;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        startCarrinho();
    }

    @Test
    @DisplayName("Create sucess")
    void save() {
       when(carrinhoRepository.save(any())).thenReturn(carrinho);

       Carrinho response = carrinhoRepository.save(carrinho);

        assertNotNull(response);
        assertEquals(Carrinho.class, response.getClass());
        assertEquals(1L, response.getId());
        assertEquals(5, response.getValorTotal());
        //assertEquals(Comprador.class, response.getComprador());
        //assertEquals(Produto.class, response.getProduto());
    }


    private void startCarrinho(){
        produto = new Produto(1L, "Bala", 0.5, 10);

        comprador = new Comprador(1L, "Maria", "081321456-90", "Rua das Flores", "40028922");

        carrinho = new Carrinho(1L, 5.00, comprador, produto);


    }

}
*/