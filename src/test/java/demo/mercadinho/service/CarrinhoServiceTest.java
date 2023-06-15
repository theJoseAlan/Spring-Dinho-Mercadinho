/*package demo.mercadinho.service;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.CarrinhoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CarrinhoServiceTest {

    @Mock
    private CarrinhoRepository carrinhoRepository;

    @InjectMocks
    private CarrinhoService carrinhoService;

    @Mock
    private CompradorService compradorService;

    @Mock
    private ProdutoService produtoService;

    private Carrinho carrinho;

    private Produto produto;

    private Comprador comprador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        startCarrinho();
    }

    @Test
    void criar() {
        Mockito.when(carrinhoRepository.save(Mockito.any())).thenReturn(carrinho);
        Mockito.when(compradorService.buscarPorId(Mockito.anyLong())).thenReturn(comprador);

        Produto produto = carrinho.getProduto();
        Mockito.when(produtoService.buscarPorId(Mockito.anyLong())).thenReturn(produto);

        Carrinho resposta = carrinhoService.criar(carrinho);

        assertNotNull(resposta);
        assertEquals(Carrinho.class, resposta.getClass());
        assertEquals(1L, resposta.getId());

        assertNotNull(resposta.getComprador());
        assertNotNull(resposta.getProduto());

        assertEquals(1L, resposta.getComprador().getId());
        assertEquals("Ana", resposta.getComprador().getNome());
        assertEquals("1234", resposta.getComprador().getCpf());
        assertEquals("Endereco", resposta.getComprador().getEndereco());
        assertEquals("4321", resposta.getComprador().getTelefone());

        assertEquals(1L, resposta.getProduto().getId());
        assertEquals("Arroz", resposta.getProduto().getNome());
        assertEquals(3.50, resposta.getProduto().getValorUnitario());
        assertEquals(2, resposta.getProduto().getQuantidade());
        assertEquals(7.0, resposta.getProduto().getValorTotal());
    }

    void startCarrinho() {
        comprador = new Comprador(1L, "Ana", "1234", "Endereco", "4321");
        produto = new Produto(1L, "Arroz", 3.50, 2, 7.0);

        carrinho = new Carrinho(1L, comprador, produto);
    }
}*/