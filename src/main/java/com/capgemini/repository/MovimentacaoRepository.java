package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {

}
