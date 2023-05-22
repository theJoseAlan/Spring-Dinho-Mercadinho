# Dinho Mercadinho
## API desenvolvida para pôr em prática meus conhecimentos de JUnit

## Tecnologias/Ferramentas usadas

* <img align="center" alt="Alan-Java" height="30" width="40" src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg"> Java<br>
* <img align="center" alt="Alan-MySql" height="30" width="40"  src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg"/>PostgreSql<br>
* <img align="center" alt="Alan-Spring" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg"> Spring<br>
* <img align="center" alt="Alan-Maven" height="30" width="40" src="https://user-images.githubusercontent.com/117518719/216434196-b63f5ea3-057f-42e5-abfc-b35deade0635.png"> Maven<br>
* <img align="center" alt="Alan-Postman" height="30" width="40" src="https://user-images.githubusercontent.com/117518719/216434927-59ceed3f-b838-42b3-845e-1975e2cb08a0.svg"> Posman<br>
* <img align="center" alt="Alan-JUnit" height="30" width="30" src="https://github.com/theJoseAlan/Spring-Dinho-Mercadinho/assets/117518719/8c7edfd2-1964-4572-bb86-ad137f2d1b08.png"> JUnit 5 (Mockito)<br>
* <img align="center" alt="Alan-Intellij" height="30" width="40" src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/intellij/intellij-original.svg"> Intellij<br>


## ⭐ Breve descrição

O sistema possui três entidades (Comprador, Produto, Carrinho)<br>

Ao criar um produto e um comprador, eles serão adicionados em no Carrinho. Assim, o carrinho conterá um produto e os dois estarão associados a um comprador

## ⚙️ Operações
* Comprador: Criar (Post), Listar todos (Get), Obter por id (Get), Atualizar (Put) e deletar por id (Delete)
* Produto: Criar (Post), Obter por id (Get)
* Carrinho: Criar (Post), Obter por id (Get)

## 🌫 Camadas (Pacotes)

| Camada | Função |
| ------------- | ------------- |
| Entity | Inserção/recepção  de atributos e conf. das classes |
| Repository | Extende JpaRepository para métodos de CRUD |
| Controller | Configurar verbos e status HTTP |
| Service | Regras do sistema e ações CRUD |

### 👀 Testes
Os testes foram realizados nas camadas de Controller e Service, além da classe principal. Dessa forma, os métodos e atributos das demais classes puderam ser testadas também
Veja abaixo um exemplo de teste do método create da classe Carrinho:

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
    
Perceba que apenas o teste deste método já cobre uma boa parte do código: Testa os atributos das duas classes associadas ao carrinho (Comprador e Produto)
e verifica se as duas não estão nulas. Além disso, a resposta da requisição HTTP também é testada, isso garante que não retorne uma resposta diferente
da que fio configurada no método POST em controller. É importante que cada teste dentro dos Assertions seja feito com muito cuidado e atenção para garantir
uma cobertura de 100% do sistema.










