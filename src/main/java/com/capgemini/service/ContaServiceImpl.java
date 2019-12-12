package com.capgemini.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.error.ResourceNotFoundException;
import com.capgemini.model.Conta;
import com.capgemini.repository.ContaRepository;

@Service
@Transactional
public class ContaServiceImpl implements ContaService {

	@Autowired
	private final ContaRepository contaRepository;

	public ContaServiceImpl(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}

	@Override
	public Conta create(Conta c) {
		if (c.getId() == null) {
			if (contaRepository.existsByNumConta(c.getNumConta())) {
				throw new ResourceNotFoundException("Conta já existe");
			} else {
				return contaRepository.save(c);
			}

		} else {
			return contaRepository.save(c);
		}
	}

	@Override
	public Conta findByNumConta(String numConta) {
		if (contaRepository.existsByNumConta(numConta)) {
			return contaRepository.findByNumConta(numConta);
		} else {
			throw new ResourceNotFoundException("Conta não existe");
		}
	}


}
