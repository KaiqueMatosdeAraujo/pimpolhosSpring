package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="itemNf")
public class ItemNf {

	@EmbeddedId
	private ItemNfID itemNfID;

	
	@Column(nullable = false)
	private BigDecimal valorUnitario;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private BigDecimal valorIcmsItem;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codProduto", insertable=false, updatable=false)
	private Produto produto;


	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorIcmsItem() {
		return valorIcmsItem;
	}

	public void setValorIcmsItem(BigDecimal valorIcmsItem) {
		this.valorIcmsItem = valorIcmsItem;
	}
	
	

	public ItemNfID getItemNfID() {
		return itemNfID;
	}

	public void setItemNfID(ItemNfID itemNfID) {
		this.itemNfID = itemNfID;
	}

	
	
	
}
