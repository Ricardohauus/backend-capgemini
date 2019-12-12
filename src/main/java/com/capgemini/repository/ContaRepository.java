package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

	boolean existsByNumConta(String numConta);

	Conta findByNumConta(String numConta);

}
