package demo.mercadinho.mapper;

import demo.mercadinho.entidades.Carrinho;
import demo.mercadinho.entidades.dto.CarrinhoDto;

public class CarrinhoMapper {


    public static CarrinhoDto carrinhoToCarrinhoDto(Carrinho carrinho){

        CarrinhoDto carrinhoDto = new CarrinhoDto();

        carrinhoDto.setId(carrinho.getId());
        carrinhoDto.setNomeComprador(carrinho.getComprador().getNome());
        carrinhoDto.setEnderecoComprador(carrinho.getComprador().getEndereco());
        carrinhoDto.setValorTotal(carrinho.getProduto().getValorTotal());

        return carrinhoDto;
    }

}
