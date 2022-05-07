package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pix")
public class Pix {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPix;
	
	@Column(nullable = false)
	 private String linkQr;
	
//	@ManyToOne(fetch = FetchType.EAGER) 
//	@JoinColumn(name = "codOperacao") 
//	private TipoPagamento tipoPagamento;

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
