package com.capgemini.service;

import com.capgemini.model.Cliente;

public interface ClienteService {

	/*
	 * Cadastra um novo Cliente
	 * 
	 * @param Cliente, O Cliente que será criado
	 * 
	 * @return O Cliente que foi cadastrado
	 * 
	 * @throws Se existir um Cliente com o mesmo CPF retorna uma mensagem de erro
	 * 
	 */

	public Cliente create(Cliente c);

}
