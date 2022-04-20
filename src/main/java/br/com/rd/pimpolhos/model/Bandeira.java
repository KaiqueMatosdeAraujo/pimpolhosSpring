package br.com.rd.pimpolhos.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="bandeira")
public class Bandeira {
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Integer codBandeira;
	
	@Column(nullable = false)
	@Length(max = 20)
	private String descricaoBandeira;

//	public Integer getCod_bandeira() {
//		return codBandeira;
//	}
//
//	public void setCod_bandeira(Integer cod_bandeira) {
//		this.codBandeira = cod_bandeira;
//	}

	public String getDescricao_bandeira() {
		return descricaoBandeira;
	}

	public void setDescricao_bandeira(String descricao_bandeira) {
		this.descricaoBandeira = descricao_bandeira;
	}

	
	
	
}
