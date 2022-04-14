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
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_bandeira;
	
	@Column(nullable = false)
	@Length(max = 20)
	private String descricao_bandeira;

	public Integer getCod_bandeira() {
		return cod_bandeira;
	}

	public void setCod_bandeira(Integer cod_bandeira) {
		this.cod_bandeira = cod_bandeira;
	}

	public String getDescricao_bandeira() {
		return descricao_bandeira;
	}

	public void setDescricao_bandeira(String descricao_bandeira) {
		this.descricao_bandeira = descricao_bandeira;
	}

	@Override
	public String toString() {
		return "Bandeira [cod_bandeira=" + cod_bandeira + ", descricao_bandeira=" + descricao_bandeira + "]";
	}
	
	
}
