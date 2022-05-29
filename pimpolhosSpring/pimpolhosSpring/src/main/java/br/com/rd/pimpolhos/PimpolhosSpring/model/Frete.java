package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frete")
public class Frete {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codFrete;
	
	@Column(nullable = false)
	private String descricaoFrete;
	
	@Column(nullable = false)
	private BigDecimal valorFrete;

	public Integer getCodFrete() {
		return codFrete;
	}

	public void setCodFrete(Integer codFrete) {
		this.codFrete = codFrete;
	}

	public String getDescricaoFrete() {
		return descricaoFrete;
	}

	public void setDescricaoFrete(String descricaoFrete) {
		this.descricaoFrete = descricaoFrete;
	}

	public BigDecimal getValorFrete() {
		return valorFrete;
	}

	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}

	@Override
	public String toString() {
		return "Frete [codFrete=" + codFrete + ", descricaoFrete=" + descricaoFrete + ", valorFrete=" + valorFrete
				+ "]";
	}
	
}
