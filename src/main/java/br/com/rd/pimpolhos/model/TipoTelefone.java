package br.com.rd.pimpolhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_telefone")
public class TipoTelefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_tipo_telefone;
	
	@Column(nullable = false)
	private String descricao_telefone;
	

	public Integer getCod_tipo_telefone() {
		return cod_tipo_telefone;
	}

	public String getDescricao_telefone() {
		return descricao_telefone;
	}

	public void setCod_tipo_telefone(Integer cod_tipo_telefone) {
		this.cod_tipo_telefone = cod_tipo_telefone;
	}

	public void setDescricao_telefone(String descricao_telefone) {
		this.descricao_telefone = descricao_telefone;
	}
	

	@Override
	public String toString() {
		return "TipoTelefone [cod_tipo_telefone=" + cod_tipo_telefone + 
				", descricao_telefone=" + descricao_telefone + "]";
	}
	
}
