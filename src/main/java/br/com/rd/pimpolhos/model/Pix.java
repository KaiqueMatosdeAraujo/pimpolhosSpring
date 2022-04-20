package br.com.rd.pimpolhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="pix")
public class Pix {

	//codOperacao
	//codFormaPagamento
	@Column(nullable = false)
	 private String linkQr;

	public String getLinkQr() {
		return linkQr;
	}

	public void setLinkQr(String linkQr) {
		this.linkQr = linkQr;
	}

	@Override
	public String toString() {
		return "Pix [linkQr=" + linkQr + "]";
	}
	
	
}
