package com.capgemini.service;

import com.capgemini.model.Movimentacao;

public interface MovimentacaoService {

	/*
	 * Realiza as movimentações de Saque ou Deposito da Conta
	 * 
	 * @param Movimentacao, A movimentação com o tipo de transação
	 * 
	 * @return A Movimentação com erro ou sucesso
	 */

	public Movimentacao create(Movimentacao m);

}
