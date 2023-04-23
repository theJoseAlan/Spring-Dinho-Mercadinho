package br.com.bentinho.mercadinho.repository;

import br.com.bentinho.mercadinho.entity.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompradorRepository extends JpaRepository<Comprador, Long> {

}
