package demo.mercadinho.controller;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.entidades.Produto;
import demo.mercadinho.model.StatusCompra;
import demo.mercadinho.repository.CarrinhoRepository;
import demo.mercadinho.repository.CompradorRepository;
import demo.mercadinho.repository.ProdutoRepository;
import demo.mercadinho.service.CarrinhoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class CarrinhoControllerTest {

    @Mock
    private CarrinhoRepository carrinhoRepository;

    @Mock
    private CompradorRepository compradorRepository;

    @Mock
    private ProdutoRepository produtoRepository;

    @Mock
    private CarrinhoService carrinhoService;

    @InjectMocks
    private CarrinhoController carrinhoController;

    private Carrinho carrinho;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startCarrinho();
    }

    @Test
    void criar() {
        when(carrinhoRepository.save(carrinho)).thenReturn(carrinho);

        ResponseEntity<Carrinho> response = carrinhoController.criar(carrinho);

        Assertions.assertNotNull(response);
    }

    @Test
    void exibeporId() {
        when(carrinhoRepository.findById(1L)).thenReturn(Optional.of(carrinho));

        ResponseEntity<Optional<Carrinho>> response = carrinhoController.exibeporId(1L);

        Assertions.assertNotNull(response);
    }

    void startCarrinho() {
        carrinho = new Carrinho();
        Produto produto = new Produto(1L, "Arroz", 10.00, 2);
        Comprador comprador = new Comprador(1L, "Ana", "123", "Rua", "321");

        carrinho.setId(1L);
        carrinho.setProduto(produto);
        carrinho.setComprador(comprador);
        carrinho.setValorTotal(produto.getValorUnitario() * produto.getQuantidade());
        carrinho.setStatusCompra(StatusCompra.FINALIZADA);
    }
}