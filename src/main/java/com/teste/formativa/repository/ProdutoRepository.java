package com.teste.formativa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.teste.formativa.entities.Produto;

public interface ProdutoRepository extends JpaRepository <Produto, Long>{

}
