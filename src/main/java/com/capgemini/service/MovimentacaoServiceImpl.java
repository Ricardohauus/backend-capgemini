package com.capgemini.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.error.ResourceNotFoundException;
import com.capgemini.model.Conta;
import com.capgemini.model.Movimentacao;
import com.capgemini.repository.MovimentacaoRepository;

@Service
@Transactional
public class MovimentacaoServiceImpl implements MovimentacaoService {

	@Autowired
	MovimentacaoRepository movimentacaoRepository;

	@Autowired
	ContaService contaService;

	public MovimentacaoServiceImpl(MovimentacaoRepository movimentacaoRepository, ContaService contaService) {
		this.movimentacaoRepository = movimentacaoRepository;
		this.contaService = contaService;
	}

	@Override
	public Movimentacao create(Movimentacao m) {

		Conta c = contaService.findByNumConta(m.getConta().getNumConta());
		m.setConta(c);
		if (m.getTipoMov().equals("D")) {
			c.setSaldoConta(c.getSaldoConta() + m.getValor());
			contaService.create(c);			
			return movimentacaoRepository.save(m);
		} else {
			if (c.getSaldoConta() < m.getValor()) {
				throw new ResourceNotFoundException("Saldo Insuficiente");
			}
			c.setSaldoConta(c.getSaldoConta() - m.getValor());
			contaService.create(c);
			return movimentacaoRepository.save(m);
		}

	}
}
