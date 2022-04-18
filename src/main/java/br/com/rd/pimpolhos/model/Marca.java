package br.com.rd.pimpolhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_marca;
	
	@Column(nullable = false)
	private String nome_marca;
	
	@Column(nullable = false)
	public Integer getCod_marca() {
		return cod_marca;
	}

	
	public String getNome_marca() {
		return nome_marca;
	}

	public void setCod_marca(Integer cod_marca) {
		this.cod_marca = cod_marca;
	}

	public void setNome_marca(String nome_marca) {
		this.nome_marca = nome_marca;
	}

	@Override
	public String toString() {
		return "Marca [cod_marca=" + cod_marca + ", nome_marca=" + nome_marca + "]";
	}
	
}
