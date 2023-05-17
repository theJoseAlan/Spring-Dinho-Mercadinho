package demo.mercadinho.service;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.entidades.Produto;
import demo.mercadinho.model.StatusCompra;
import demo.mercadinho.repository.CarrinhoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CarrinhoServiceTest {

    public static final long IDComprador = 1L;
    public static final long IDProduto = 1L;
    public static final String NomeComprador = "Ana";
    public static final String CPFComprador = "081222";
    public static final String ENDERECOComprador = "Endereco";
    public static final String TELEFONEComprador = "12345";
    public static final String NOMEPRoduto = "Bala";
    public static final double VALOR_UNITARIO = 0.5;
    public static final int QUANTIDADE = 10;
    @Mock
    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @InjectMocks
    private CarrinhoService carrinhoService;

    private Carrinho carrinho;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);

        startCarrinho();
    }

    @Test
    void save() {
        when(carrinhoRepository.save(any())).thenReturn(carrinho);

        Carrinho resultado = carrinhoService.save(carrinho);

        assertEquals(carrinho, resultado);

        assertEquals(Carrinho.class, resultado.getClass());

        assertNotNull(resultado.getClass());
        assertNotNull(resultado.getId());

        assertEquals(1L, resultado.getId());
        assertEquals(5, resultado.getValorTotal());
        assertEquals(StatusCompra.FINALIZADA, resultado.getStatusCompra());

        //Veficação do objeto comprador dentro do Carrinho
        assertNotNull(resultado.getComprador());
        assertEquals(Comprador.class, resultado.getComprador().getClass());
        assertNotNull(resultado.getComprador().getId());
        assertEquals(IDComprador, resultado.getComprador().getId());
        assertEquals(NomeComprador, resultado.getComprador().getNome());
        assertEquals(CPFComprador, resultado.getComprador().getCpf());
        assertEquals(ENDERECOComprador, resultado.getComprador().getEndereco());
        assertEquals(TELEFONEComprador, resultado.getComprador().getTelefone());

        //Veficação do objeto produto dentro do Carrinho
        assertNotNull(resultado.getProduto());
        assertEquals(Produto.class, resultado.getProduto().getClass());
        assertNotNull(resultado.getProduto().getId());
        assertEquals(IDProduto, resultado.getProduto().getId());
        assertEquals(NOMEPRoduto, resultado.getProduto().getNome());
        assertEquals(VALOR_UNITARIO, resultado.getProduto().getValorUnitario());
        assertEquals(QUANTIDADE, resultado.getProduto().getQuantidade());
        double valorTotal = resultado.getProduto().getValorUnitario()*resultado.getProduto().getQuantidade();
        assertEquals(VALOR_UNITARIO*QUANTIDADE, valorTotal);


    }

    void startCarrinho(){
        Comprador comprador = new Comprador(IDComprador, NomeComprador, CPFComprador,
                ENDERECOComprador, TELEFONEComprador);

        Produto produto = new Produto(IDProduto, NOMEPRoduto, VALOR_UNITARIO, QUANTIDADE);

        Double valortotal = produto.getQuantidade()* produto.getValorUnitario();

        carrinho = new Carrinho(1L, valortotal, comprador, produto, StatusCompra.FINALIZADA);
    }
}