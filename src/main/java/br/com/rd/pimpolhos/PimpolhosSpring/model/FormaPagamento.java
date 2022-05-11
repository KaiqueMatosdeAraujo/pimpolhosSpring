package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="forma_pagamento")
public class FormaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codFormaPagamento;
	private String descricao;
	
	
	public Integer getCodFormaPagamento() {
		return codFormaPagamento;
	}
	
	public void setCodFormaPagamento(Integer codFormaPagamento) {
		this.codFormaPagamento = codFormaPagamento;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	
}
