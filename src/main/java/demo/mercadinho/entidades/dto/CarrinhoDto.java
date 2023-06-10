package demo.mercadinho.entidades.dto;

import lombok.Data;

@Data
public class CarrinhoDto {

    private Long id;

    private String nomeComprador;

    private String enderecoComprador;

    private Double valorTotal;

}
