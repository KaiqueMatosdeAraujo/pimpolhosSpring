package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ItemNfID implements Serializable{

	private Integer codProduto;
	private Integer codItemNota;
	
	public Integer getCodProduto() {
		return codProduto;
	}
	
	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}
	
	public Integer getCodItemNota() {
		return codItemNota;
	}
	
	public void setCodItemNota(Integer codItemNota) {
		this.codItemNota = codItemNota;
	}
	
	
}
