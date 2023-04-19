package br.com.bentinho.mercadinho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Comprador {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long telefone;

    private String endereco;

    @OneToOne
    private Carrinho carrinho;

    public Comprador(){

    }
}
