package com.capgemini.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Cliente;
import com.capgemini.model.Conta;
import com.capgemini.service.ClienteService;
import com.capgemini.service.ContaService;

@RestController
@RequestMapping("/clientes")
public class ClienteResource {

	@Autowired
	ClienteService clienteService;

	@Autowired
	ContaService contaService;

	public ClienteResource(ClienteService clienteService, ContaService contaService) {
		this.clienteService = clienteService;
		this.contaService = contaService;
	}

	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create() {
		iniciarSistema();
		return null;
	}

	public void iniciarSistema() {

		Cliente c = new Cliente();
		c.setCpf("31493686003");
		c.setNome("Ricardo Brasil");
		clienteService.create(c);

		Conta conta = new Conta();
		conta.setCliente(c);
		conta.setNumConta("0001");
		conta.setSaldoConta(0.0);
		conta.setSenhaConta("123456");
		conta.setTipoConta(1);
		contaService.create(conta);

		c = new Cliente();
		c.setCpf("48048248042");
		c.setNome("Alan Marques");
		clienteService.create(c);

		conta = new Conta();
		conta.setCliente(c);
		conta.setNumConta("0002");
		conta.setSaldoConta(0.0);
		conta.setSenhaConta("123456");
		conta.setTipoConta(1);
		contaService.create(conta);
	}

}
