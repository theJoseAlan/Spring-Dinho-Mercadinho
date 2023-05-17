package demo.mercadinho.controller;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.entidades.Produto;
import demo.mercadinho.model.StatusCompra;
import demo.mercadinho.repository.CarrinhoRepository;
import demo.mercadinho.service.CarrinhoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest
class CarrinhoControllerTest {
    public static final long IDComprador = 1L;
    public static final long IDProduto = 1L;
    public static final String NomeComprador = "Ana";
    public static final String CPFComprador = "081222";
    public static final String ENDERECOComprador = "Endereco";
    public static final String TELEFONEComprador = "12345";
    public static final String NOMEProduto = "Bala";
    public static final double VALOR_UNITARIO = 0.5;
    public static final int QUANTIDADE = 10;

    private Carrinho carrinho;

    @Mock
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @InjectMocks
    private CarrinhoController carrinhoController;

    @Mock
    private CarrinhoService carrinhoService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        startCarrinho();
    }

    @Test
    void criar() {
        when(carrinhoService.save(Mockito.any())).thenReturn(carrinho);

        ResponseEntity<Carrinho> response = carrinhoController.criar(carrinho);

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertNotNull(response.getBody().getId());

        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

        assertEquals(1L, response.getBody().getId());
        assertEquals(5, response.getBody().getValorTotal());
        assertEquals(StatusCompra.FINALIZADA, response.getBody().getStatusCompra());
        assertNotNull(response.getBody().getComprador());
        assertNotNull(response.getBody().getProduto());

        assertEquals(Comprador.class, response.getBody().getComprador().getClass());
        assertEquals(Produto.class, response.getBody().getProduto().getClass());

        assertNotNull(response.getBody().getComprador().getId());
        assertEquals(IDComprador, response.getBody().getComprador().getId());
        assertEquals(NomeComprador, response.getBody().getComprador().getNome());
        assertEquals(CPFComprador, response.getBody().getComprador().getCpf());
        assertEquals(TELEFONEComprador, response.getBody().getComprador().getTelefone());
        assertEquals(ENDERECOComprador, response.getBody().getComprador().getEndereco());

        assertNotNull(response.getBody().getProduto().getId());
        assertNotEquals(IDProduto, response.getBody().getProduto().getId());
        assertEquals(NOMEProduto, response.getBody().getProduto().getNome());
        assertEquals(VALOR_UNITARIO, response.getBody().getProduto().getValorUnitario());
        assertEquals(QUANTIDADE, response.getBody().getProduto().getQuantidade());

        Double valorTotal = response.getBody().getProduto().getValorUnitario()*response.getBody().
                getProduto().getQuantidade();

        assertEquals(VALOR_UNITARIO*QUANTIDADE, valorTotal);


    }

    @Test
    void exibeporId() {
    }


    void startCarrinho(){

        Comprador comprador = new Comprador(IDComprador, NomeComprador, CPFComprador,
                ENDERECOComprador, TELEFONEComprador);

        Produto produto = new Produto(IDProduto, NOMEProduto, VALOR_UNITARIO, QUANTIDADE);


        Double valortotal = produto.getQuantidade()* produto.getValorUnitario();

        carrinho = new Carrinho(1L, valortotal, comprador, produto, StatusCompra.FINALIZADA);
    }
}