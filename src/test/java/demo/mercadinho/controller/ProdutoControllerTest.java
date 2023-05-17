package demo.mercadinho.controller;

import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.ProdutoRepository;
import demo.mercadinho.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
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

        ResponseEntity<Produto> response = produtoController.adcionar(produto);

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertNotNull(response);

        //Não sei se é necessário, se a próxima verificação passa é porque o ID não foi nulo
        //Mas vou deixar como lembrete de que é interessante verificar
        assertNotNull(response.getBody().getId());

        assertEquals(ID, response.getBody().getId());
        assertEquals(NOME, response.getBody().getNome());
        assertEquals(VALOR_UNITARIO, response.getBody().getValorUnitario());
        assertEquals(QUANTIDADE, response.getBody().getQuantidade());

        double valorTotal = response.getBody().getQuantidade()*response.getBody().getValorUnitario();

        assertEquals(QUANTIDADE*VALOR_UNITARIO, valorTotal);

    }

    @Test
    void exibe() {
        when(produtoRepository.findById(any())).thenReturn(Optional.of(produto));

        ResponseEntity<Optional<Produto>> response = produtoController.exibe(ID);

        assertNotNull(response);
        assertNotNull(response.getBody());

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(Optional.class, response.getBody().getClass());

        assertEquals(ResponseEntity.class, response.getClass());

        assertEquals(ID, response.getBody().get().getId());
        assertEquals(NOME, response.getBody().get().getNome());
        assertEquals(VALOR_UNITARIO, response.getBody().get().getValorUnitario());
        assertEquals(QUANTIDADE, response.getBody().get().getQuantidade());

        double valorTotal = response.getBody().get().getQuantidade()*response.getBody().get().getValorUnitario();

        assertEquals(QUANTIDADE*VALOR_UNITARIO, valorTotal);


    }

    private void startProduto(){
        produto = new Produto(ID, NOME, VALOR_UNITARIO, QUANTIDADE);
    }
}