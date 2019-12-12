package com.capgemini.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.error.ResourceNotFoundException;
import com.capgemini.model.Cliente;
import com.capgemini.repository.ClienteRepository;

@Service
@Transactional
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository clienteRepository;

	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	@Override
	public Cliente create(Cliente c) {
		if (clienteRepository.existsByCpf(c.getCpf())) {
			throw new ResourceNotFoundException("Cliente já cadastrado");
		} else {
			return clienteRepository.save(c);
		}

	}

}
