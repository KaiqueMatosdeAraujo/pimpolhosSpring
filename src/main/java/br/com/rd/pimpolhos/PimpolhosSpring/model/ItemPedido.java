package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.util.List;

import javax.persistence.Column;
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
@Table(name="itemPedido")
public class ItemPedido {
	

	@EmbeddedId
	private ItemPedidoID itemPedidoId;
	
	@ManyToOne
	@JoinColumn(name="codProduto", insertable=false, updatable=false)
	private Produto produto;
	
	@Column(nullable = false)
	private Integer quantidade;
	

	

	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	
	@Override
	public String toString() {
		return "Item pedido [cod_item_pedido=" 
				+  ", quanidade=" + quantidade +"]";
	}

}
