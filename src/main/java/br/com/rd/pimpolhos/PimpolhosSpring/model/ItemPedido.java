package br.com.rd.pimpolhos.PimpolhosSpring.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itemPedido")
public class ItemPedido {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer itemPedidoId;
	
	@ManyToOne(cascade = CascadeType.ALL ,  fetch = FetchType.LAZY)
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
	
	


	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	@Override
	public String toString() {
		return "Item pedido [cod_item_pedido=" 
				+  ", quanidade=" + quantidade +"]";
	}

}
