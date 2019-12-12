package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	boolean existsByCpf(String cpf);

}
