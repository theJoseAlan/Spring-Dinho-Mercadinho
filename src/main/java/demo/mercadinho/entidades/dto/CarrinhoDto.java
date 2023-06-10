package demo.mercadinho.entidades.dto;

import lombok.Data;

import java.util.List;

@Data
public class CarrinhoDto {

    private Long id;

    private String nomeComprador;

    private String enderecoComprador;

    private List<String> nomeProdutos;

}
