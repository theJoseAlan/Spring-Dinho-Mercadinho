package demo.mercadinho.service;

import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class ProdutoServiceTest {

    public static final long ID = 1L;
    public static final String NOME = "Bala";
    public static final double VALOR_UNITARIO = 0.5;
    public static final int QUANTIDADE = 10;
    public static final double VALOR_TOTAL = 5.0;
    @Mock
    private ProdutoRepository produtoRepository;

    private ProdutoService produtoService;

    private Produto produto;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        produtoService = new ProdutoService(produtoRepository);

        startProduto();
    }

    @Test
    @DisplayName("Save sucess")
    void save() {
        when(produtoRepository.save(Mockito.any())).thenReturn(produto);

        Produto response = produtoService.save(produto);

        assertNotNull(response);
        assertEquals(Produto.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(VALOR_UNITARIO, response.getValorUnitario());
        assertEquals(QUANTIDADE, response.getQuantidade());
        assertEquals(VALOR_TOTAL, response.getQuantidade() * response.getValorUnitario());


    }

    @Test
    void buscar(){
        when(produtoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produto));

        Produto resultado = produtoService.buscar(produto.getId());

        assertNotNull(resultado);
        assertEquals(Produto.class, resultado.getClass());
        assertEquals(ID, resultado.getId());
        assertEquals(NOME, resultado.getNome());
        assertEquals(VALOR_UNITARIO, resultado.getValorUnitario());
        assertEquals(QUANTIDADE, resultado.getQuantidade());
        assertEquals(VALOR_TOTAL, resultado.getQuantidade() * resultado.getValorUnitario());;

    }

    private void startProduto(){
        produto = new Produto(ID, NOME, VALOR_UNITARIO, QUANTIDADE, VALOR_TOTAL);
    }
}