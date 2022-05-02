package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tipoPagamento")
public class TipoPagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codOperacao;
//	@EmbeddedId
//	private TipoPagamentoID tipoPagamentoID;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "cod_forma_pagamento") 
	private FormaPagamento formaPagamento;


	
	
	public Integer getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(Integer codOperacao) {
		this.codOperacao = codOperacao;
	}
	
	@Override
	public String toString() {
		return "Tipo de pagamento [codOperacao=" + codOperacao + "]" ;
	}
	
	
}
