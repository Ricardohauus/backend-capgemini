package com.capgemini.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// ANOTAÇÃO PARA MARCAR A CLASSE COMO UMA ENTIDADE DO JPA 
@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	// INFORMADO AO JPA QUE ESSE ATRIBUTO É A CHAVE PRIMARIA (PRIMARY_KEY) COM A
	// GERAÇÃO DO VALOR AUTOMÁTICO (AUTO_INCREMENT)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// INFORMANDO AO JPA PARA INFORMAR AO BANCO DE DADOS OS ATRIBUTOS DA COLUNA
	@Column(name = "ID")
	private Long id;

	// USADO O JAVAX VALIDATION PARA INFORMAR AS MENSAGEM DE ERRO AO FRONTEND
	@Size(min = 3, message = "O Numero da Conta deve conter no mínimo 3 caracteres")
	@Size(max = 15, message = "O Numero da conta deve conter no máximo 15 caracteres")
	@Column(nullable = false, length = 15, name = "NUMERO_CONTA", unique = true)
	private String numConta;

	@JsonIgnore
	@Size(min = 6, message = "A Senha da Conta deve conter no mínimo 6 caracteres")
	@Size(max = 10, message = "A Senha da conta deve conter no máximo 10 caracteres")
	@Column(nullable = true, length = 100, name = "SENHA_CONTA")
	private String senhaConta;

	@Column(nullable = false, name = "SALDO_CONTA", precision = 2)
	private Double saldoConta = 0.0;

	@Column(nullable = false, name = "DATA_ABERTURA")
	private Date dataAbertura;

	@Column(nullable = false, name = "TIPO_CONTA")
	private int tipoConta;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "ID")
	private Cliente cliente;

	public Conta() {
		super();
	}

	public Conta(Long id,
			@Size(min = 3, message = "O Numero da Conta deve conter no mínimo 3 caracteres") @Size(max = 15, message = "O Numero da conta deve conter no máximo 15 caracteres") String numConta,
			@Size(min = 6, message = "A Senha da Conta deve conter no mínimo 6 caracteres") @Size(max = 10, message = "A Senha da conta deve conter no máximo 10 caracteres") String senhaConta,
			Double saldoConta, Date dataAbertura, int tipoConta, Cliente cliente) {
		super();
		this.id = id;
		this.numConta = numConta;
		this.senhaConta = senhaConta;
		this.saldoConta = saldoConta;
		this.dataAbertura = dataAbertura;
		this.tipoConta = tipoConta;
		this.cliente = cliente;
	}

	// SALVAR A DATA DE ABERTURA NO MOMENTO DE CRIAÇÃO DA CONTA
	@PrePersist
	public void onPrePersist() {
		if (this.dataAbertura == null) {
			this.dataAbertura = new Date();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public String getSenhaConta() {
		return senhaConta;
	}

	public void setSenhaConta(String senhaConta) {
		this.senhaConta = senhaConta;
	}

	public Double getSaldoConta() {
		return saldoConta;
	}

	public void setSaldoConta(Double saldoConta) {
		this.saldoConta = saldoConta;
	}

	public Date getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
