package com.capgemini.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Conta;
import com.capgemini.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaResource {

	@Autowired
	ContaService contaService;
	
	@GetMapping(produces = "application/json", value = "/saldo/{numConta}")
	@ResponseBody
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> getSaldo(@PathVariable(value = "numConta") String numConta) {
		return new ResponseEntity<Conta>(this.contaService.findByNumConta(numConta), HttpStatus.OK);
	}

}
