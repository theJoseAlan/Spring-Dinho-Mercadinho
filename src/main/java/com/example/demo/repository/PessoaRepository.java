package com.example.demo.repository;

import com.example.demo.entidades.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Comprador, Long> {

}
