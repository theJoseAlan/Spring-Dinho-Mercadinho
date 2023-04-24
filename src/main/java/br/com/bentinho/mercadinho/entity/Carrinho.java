package br.com.bentinho.mercadinho.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

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

    @OneToOne(cascade = CascadeType.ALL)
    private Comprador comprador;

    @OneToOne(cascade = CascadeType.ALL)
    private Produto produto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Carrinho carrinho = (Carrinho) o;
        return getId() != null && Objects.equals(getId(), carrinho.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
