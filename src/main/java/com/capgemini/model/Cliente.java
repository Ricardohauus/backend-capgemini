package com.capgemini.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

//ANOTAÇÃO PARA MARCAR A CLASSE COMO UMA ENTIDADE DO JPA
@Entity
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	// INFORMANDO AO JPA QUE ESSE ATRIBUTO É A CHAVE PRIMARIA (PRIMARY_KEY) COM A
	// GERAÇÃO DO VALOR AUTOMÁTICO (AUTO_INCREMENT)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	// INFORMANDO AO JPA PARA INFORMAR AO BANCO DE DADOS OS ATRIBUTOS DA COLUNA
	@Column(name = "ID")
	private Long id;

	// USADO O JAVAX VALIDATION PARA INFORMAR AS MENSAGEM DE ERRO AO FRONTEND
	@Size(min = 3, message = "O Nome do Cliente deve conter no mínimo 3 caracteres")
	@Size(max = 200, message = "O Nome do Cliente deve conter no máximo 200 caracteres")
	@Column(nullable = false, length = 200, name = "NOME_CLIENTE")
	private String nome;

	@CPF(message = "Informe um CPF válido")
	@Column(nullable = false, length = 11, name = "CPF", unique = true)
	private String cpf;

	public Cliente() {
		super();
	}

	public Cliente(Long id,
			@Size(min = 1, message = "O Nome do Cliente deve conter no mínimo 3 caracteres") @Size(max = 1, message = "O Nome do Cliente deve conter no máximo 200 caracteres") String nome,
			@CPF(message = "Informe um CPF válido") String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id != other.id)
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
