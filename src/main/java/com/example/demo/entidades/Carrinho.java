package com.example.demo.entidades;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Carrinho {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;

    @OneToOne(cascade = CascadeType.ALL)
    @Embedded
    private Comprador comprador;

    @OneToOne(cascade = CascadeType.ALL)
    @Embedded
    private Produto produto;

}
