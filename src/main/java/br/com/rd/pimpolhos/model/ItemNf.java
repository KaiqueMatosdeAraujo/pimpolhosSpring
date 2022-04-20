package br.com.rd.pimpolhos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="itemNf")
public class ItemNf {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer codProduto;

	@Column(nullable = false)
	private Integer codItemNota;
	
	@Column(nullable = false)
	private BigDecimal valorUnitario;
	
	@Column(nullable = false)
	private BigDecimal valorTotal;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Column(nullable = false)
	private BigDecimal valorIcmsItem;

	public Integer getCodItemNota() {
		return codItemNota;
	}

	public void setCodItemNota(Integer codItemNota) {
		this.codItemNota = codItemNota;
	}

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

	@Override
	public String toString() {
		return "ItemNf [codItemNota=" + codItemNota + ", valorUnitario=" + valorUnitario + ", valorTotal=" + valorTotal
				+ ", quantidade=" + quantidade + ", valorIcmsItem=" + valorIcmsItem + "]";
	}

	
	
}
