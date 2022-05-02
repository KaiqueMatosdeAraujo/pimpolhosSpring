package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemPedido")
public class ItemPedido {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer codItemPedido;
	@EmbeddedId
	private ItemPedidoID itemPedidoId;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	
	
//	private Integer codProduto;

//	public Integer getCodItemPedido() {
//		return codItemPedido;
//	}


	public Integer getQuantidade() {
		return quantidade;
	}

//	public void setCodItemPedido(Integer codItemPedido) {
//		this.codItemPedido = codItemPedido;
//	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	@Override
	public String toString() {
		return "Item pedido [cod_item_pedido=" 
				+  ", quanidade=" + quantidade +"]";
	}

}
