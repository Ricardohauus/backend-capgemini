package com.capgemini.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.model.Movimentacao;
import com.capgemini.service.MovimentacaoService;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoResource {
	@Autowired
	MovimentacaoService movimentacaoService;

	@PostMapping()
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> create(@Valid @RequestBody Movimentacao m) {
		return new ResponseEntity<Movimentacao>(this.movimentacaoService.create(m), HttpStatus.CREATED);
	}
}
