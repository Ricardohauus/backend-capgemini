package com.capgemini.service;

import com.capgemini.model.Conta;

public interface ContaService {

	/*
	 * Cria uma nova conta
	 * 
	 * @param Conta, A Conta que será criada
	 * 
	 * @return A Conta que foi criada
	 * 
	 * @throws Se existir uma conta retorna uma mensagem de erro
	 * 
	 */

	public Conta create(Conta c);

	/*
	 * Pesquisa uma Conta pelo número da Conta
	 * 
	 * @param numConta, O numero da conta
	 * 
	 * @return A Conta que foi pesquisada
	 */

	public Conta findByNumConta(String numConta);


}
