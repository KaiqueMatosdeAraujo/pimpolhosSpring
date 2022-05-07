package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ItemPedidoID implements Serializable{

	private Integer codItemPedido;
	private Integer codProduto;
	
	public Integer getCodItemPedido() {
		return codItemPedido;
	}
	
	public void setCodItemPedido(Integer codItemPedido) {
		this.codItemPedido = codItemPedido;
	}
	
	public Integer getCodProduto() {
		return codProduto;
	}
	
	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}
	
	
}
