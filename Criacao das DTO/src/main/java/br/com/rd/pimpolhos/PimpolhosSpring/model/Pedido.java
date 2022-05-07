package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPedido;
	
	@Column(nullable = false)
	private LocalDate dataPedido;
	
	//codFrete OK
	//codEndereco
	//codCliente
	//codStatus OK
	//codOperacao 
	//codFormaPagamento
	//codItemPedido
	

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "codFrete") 
	private Frete frete; 
	
	@ManyToOne (fetch = FetchType.EAGER) 
	@JoinColumn(name = "codStatus") 
	private StatusPedido statusPedido; 

//	@ManyToOne(fetch = FetchType.EAGER) 
//	@JoinColumns(value ={  
//	@JoinColumn(name="codOperacao", insertable = false, updatable = false),
//	@JoinColumn(name="cod_forma_pagamento", insertable = false, updatable = false)})
//	private TipoPagamento tipoPagamento;
	
	@OneToMany
	@JoinColumn(name="codItemPedido")
	private List<ItemPedido> itemPedido;
	
	
	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	@Override
	public String toString() {
		return "Pedido [codPedido=" + codPedido + ", dataPedido=" + dataPedido + "]";
	}
	

	
	
	
}
