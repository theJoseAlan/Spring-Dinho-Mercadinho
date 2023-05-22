package demo.mercadinho.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Produto {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public Long id;

    private String nome;

    private Double valorUnitario;

    private int quantidade;

    private Double valorTotal;

    public Produto(){

    }


}
