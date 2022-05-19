package br.com.rd.pimpolhos.PimpolhosSpring.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="itemPedido")
public class ItemPedido {
	

	@EmbeddedId
	private ItemPedidoID itemPedidoId;
	
	@ManyToOne
	@JoinColumn(name="codProduto", insertable=false, updatable=false)
	private Produto codProduto;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="codPedido", insertable=false, updatable=false)
	private Pedido codPedido;
	

	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	


	

	public Produto getCodProduto() {
		return codProduto;
	}


	public void setCodProduto(Produto codProduto) {
		this.codProduto = codProduto;
	}


	public Pedido getCodPedido() {
		return codPedido;
	}


	public void setCodPedido(Pedido codPedido) {
		this.codPedido = codPedido;
	}


	@Override
	public String toString() {
		return "Item pedido [cod_item_pedido=" 
				+  ", quanidade=" + quantidade +"]";
	}

}
