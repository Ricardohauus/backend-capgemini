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
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//ANOTAÇÃO PARA MARCAR A CLASSE COMO UMA ENTIDADE DO JPA
@Entity
public class Movimentacao implements Serializable {

	private static final long serialVersionUID = 1L;

	// INFORMADO AO JPA QUE ESSE ATRIBUTO É A CHAVE PRIMARIA (PRIMARY_KEY) COM A
	// GERAÇÃO DO VALOR AUTOMÁTICO (AUTO_INCREMENT)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// INFORMANDO AO JPA PARA INFORMAR AO BANCO DE DADOS OS ATRIBUTOS DA COLUNA
	@Column(name = "ID")
	private Long id;

	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CONTA_ID", referencedColumnName = "ID", insertable = false, updatable = false)
	private Conta conta;

	@Column(nullable = false, length = 1, name = "TIPO_MOVIMENTACAO")
	private String tipoMov;

	@Column
	private Date dataMovimentacao;

	@Column(nullable = false, name = "VALOR", precision = 2)
	private double valor;

	public Movimentacao() {
		super();
	}

	public Movimentacao(Long id, Conta conta, String tipoMov, Date dataMovimentacao, double valor) {
		super();
		this.id = id;
		this.conta = conta;
		this.tipoMov = tipoMov;
		this.dataMovimentacao = dataMovimentacao;
		this.valor = valor;
	}

	// SALVAR A DATA DA MOVIMENTACÃO NO MOMENTO EM QUE A MOVIMENTAÇÃO OCORRER
	@PrePersist
	public void onPrePersist() {
		if (this.dataMovimentacao == null) {
			this.dataMovimentacao = new Date();
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Date getDataMovimentacao() {
		return dataMovimentacao;
	}

	public void setDataMovimentacao(Date dataMovimentacao) {
		this.dataMovimentacao = dataMovimentacao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getTipoMov() {
		return tipoMov;
	}

	public void setTipoMov(String tipoMov) {
		this.tipoMov = tipoMov;
	}
}
