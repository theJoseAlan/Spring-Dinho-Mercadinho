package demo.mercadinho.entidades;

import demo.mercadinho.model.StatusCompra;
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

    private Double valorTotal;

    @OneToOne(cascade = CascadeType.ALL)
    @Embedded
    private Comprador comprador;

    @OneToOne(cascade = CascadeType.ALL)
    @Embedded
    private Produto produto;

    @Enumerated(EnumType.STRING)
    private StatusCompra statusCompra;


}
