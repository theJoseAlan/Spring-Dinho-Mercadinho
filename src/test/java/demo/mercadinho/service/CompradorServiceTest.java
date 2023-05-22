package demo.mercadinho.service;

import demo.mercadinho.entidades.Comprador;
import demo.mercadinho.repository.CompradorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
class CompradorServiceTest {

    public static final long ID = 1L;
    public static final String NOME = "Ana";
    public static final String CPF = "040320";
    public static final String ENDERECO = "Endereco";
    public static final String TELEFONE = "12345";


    @Mock
    private CompradorRepository compradorRepository;

    @InjectMocks
    private CompradorService compradorService;

    private Comprador comprador;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startComprador();
    }


    @Test
    void testSalvar() {

        when(compradorRepository.save(Mockito.any())).thenReturn(comprador);

        Comprador resultado = compradorService.salvar(comprador);

        assertEquals(comprador, resultado);

        assertNotNull(ID);

        assertEquals(Comprador.class, resultado.getClass());

        assertEquals(ID, resultado.getId());
        assertEquals(NOME, resultado.getNome());
        assertEquals(CPF, resultado.getCpf());
        assertEquals(ENDERECO, resultado.getEndereco());
        assertEquals(TELEFONE, resultado.getTelefone());

    }

    @Test
    void buscar(){
        when(compradorRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(comprador));

        Comprador resultado = compradorService.buscar(comprador.getId());

        assertEquals(Comprador.class, resultado.getClass());

        assertNotNull(resultado);
        assertNotNull(resultado.getClass());
        assertEquals(ID, resultado.getId());
        assertEquals(NOME, resultado.getNome());
        assertEquals(ENDERECO, resultado.getEndereco());
        assertEquals(TELEFONE, resultado.getTelefone());
        assertEquals(CPF, resultado.getCpf());

    }

    void startComprador(){

        comprador = new Comprador(ID, NOME, CPF, ENDERECO, TELEFONE);

    }


}