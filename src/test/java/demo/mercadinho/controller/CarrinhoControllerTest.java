package demo.mercadinho.controller;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.entidades.Produto;
import demo.mercadinho.repository.CarrinhoRepository;
import demo.mercadinho.service.CarrinhoService;
import demo.mercadinho.service.CompradorService;
import demo.mercadinho.service.ProdutoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CarrinhoControllerTest {
    @Mock
    private CarrinhoRepository carrinhoRepository;

    @Mock
    private CarrinhoService carrinhoService;

    @Mock
    private CompradorService compradorService;

    @Mock
    private ProdutoService produtoService;

    @InjectMocks
    private CarrinhoController carrinhoController;

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
        Mockito.when(carrinhoService.criar(Mockito.any())).thenReturn(carrinho);

        ResponseEntity<Carrinho> response = carrinhoController.criar(carrinho);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());
        assertNotNull(response.getBody().getProduto());
        assertNotNull(response.getBody().getComprador());

        assertEquals(HttpStatus.OK, response.getStatusCode());

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(Carrinho.class, response.getBody().getClass());
        assertEquals(Produto.class, response.getBody().getProduto().getClass());
        assertEquals(Comprador.class, response.getBody().getComprador().getClass());

        assertEquals(1L, response.getBody().getComprador().getId());
        assertEquals("Ana", response.getBody().getComprador().getNome());
        assertEquals("1234", response.getBody().getComprador().getCpf());
        assertEquals("Endereco", response.getBody().getComprador().getEndereco());
        assertEquals("4321", response.getBody().getComprador().getTelefone());

        assertEquals(1L, response.getBody().getProduto().getId());
        assertEquals("Arroz", response.getBody().getProduto().getNome());
        assertEquals(3.50, response.getBody().getProduto().getValorUnitario());
        assertEquals(2, response.getBody().getProduto().getQuantidade());
        assertEquals(7, response.getBody().getProduto().getValorTotal());

        Double total = response.getBody().getProduto().getValorUnitario()*response.getBody().getProduto().getQuantidade();

        assertEquals(total, response.getBody().getProduto().getValorTotal());


    }

    @Test
    void exibir() {
        Mockito.when(carrinhoRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(carrinho));

        ResponseEntity<Optional<Carrinho>> response = carrinhoController.exibir(1L);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(ResponseEntity.class, response.getClass());

        assertEquals(Carrinho.class, response.getBody().get().getClass());
        assertNotNull(response.getBody().get().getProduto());
        assertNotNull(response.getBody().get().getComprador());

        assertNotNull(response.getBody().get().getId());
        assertNotNull(response.getBody().get().getComprador().getId());
        assertNotNull(response.getBody().get().getProduto().getId());

        assertEquals(Comprador.class, response.getBody().get().getComprador().getClass());
        assertEquals(Produto.class, response.getBody().get().getProduto().getClass());

        assertEquals(1L, response.getBody().get().getComprador().getId());
        assertEquals("Ana", response.getBody().get().getComprador().getNome());
        assertEquals("1234", response.getBody().get().getComprador().getCpf());
        assertEquals("Endereco", response.getBody().get().getComprador().getEndereco());
        assertEquals("4321", response.getBody().get().getComprador().getTelefone());

        assertEquals(1L, response.getBody().get().getProduto().getId());
        assertEquals("Arroz", response.getBody().get().getProduto().getNome());
        assertEquals(3.50, response.getBody().get().getProduto().getValorUnitario());
        assertEquals(2, response.getBody().get().getProduto().getQuantidade());
        assertEquals(7, response.getBody().get().getProduto().getValorTotal());

        Double total = response.getBody().get().getProduto().getValorUnitario()*response.getBody().get().getProduto().getQuantidade();

        assertEquals(total, response.getBody().get().getProduto().getValorTotal());


    }

    void startCarrinho() {
        comprador = new Comprador(1L, "Ana", "1234", "Endereco", "4321");
        produto = new Produto(1L, "Arroz", 3.50, 2, 7.0);

        carrinho = new Carrinho(1L, comprador, produto);
    }
}