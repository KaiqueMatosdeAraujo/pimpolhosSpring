package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ItemPedidoID implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer codPedido;
	private Integer codProduto;
	
	
	public Integer getCodPedido() {
		return codPedido;
	}
	
	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}
	
	public Integer getCodProduto() {
		return codProduto;
	}
	
	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}
	
	
	
	
}