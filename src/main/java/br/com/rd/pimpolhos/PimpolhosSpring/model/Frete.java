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
	private Integer cod_frete;
	
	@Column(nullable = false)
	private String descricao_frete;
	
	@Column(nullable = false)
	private BigDecimal valor_frete;
	

	public Integer getCod_frete() {
		return cod_frete;
	}

	public void setCod_frete(Integer cod_frete) {
		this.cod_frete = cod_frete;
	}

	public String getDescricao_frete() {
		return descricao_frete;
	}

	public void setDescricao_frete(String descricao_frete) {
		this.descricao_frete = descricao_frete;
	}

	public BigDecimal getValor_frete() {
		return valor_frete;
	}

	public void setValor_frete(BigDecimal valor_frete) {
		this.valor_frete = valor_frete;
	}

	@Override
	public String toString() {
		return "Frete [cod_frete=" + cod_frete + ", descricao_frete=" + descricao_frete + ", valor_frete=" + valor_frete
				+ "]";
	}
	
	
	
}
