package br.com.bentinho.mercadinho.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;



@Getter
@Setter
@AllArgsConstructor
@Entity
public class Comprador {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long telefone;

    private String endereco;

    public Comprador(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Comprador comprador = (Comprador) o;
        return getId() != null && Objects.equals(getId(), comprador.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
