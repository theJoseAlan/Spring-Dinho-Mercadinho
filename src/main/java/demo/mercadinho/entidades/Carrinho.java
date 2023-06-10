package demo.mercadinho.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Entity
public class Carrinho {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Comprador comprador;

    //A lista tem um ID, por isso que adciono vários produtos e todos vão de uma vez
    //Resolve: Vai adicionando os prodtos e cria um endpoint delete para os que não quer, o carrinho é
    //a confirmação dos que quero
    //No putmapping do carrinho a compra recebe o status finalizada
    @OneToMany(cascade = CascadeType.ALL)
    private List<Produto> produtos;


    public Carrinho(){

    }

}
