package br.com.bentinho.mercadinho.repository;

import br.com.bentinho.mercadinho.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
