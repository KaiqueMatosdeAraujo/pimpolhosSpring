package br.com.rd.pimpolhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_categoria;

	@Column(nullable = false)
	private String nome_categoria;

	public Integer getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(Integer cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	public String getNome_categoria() {
		return nome_categoria;
	}

	public void setNome_categoria(String nome_categoria) {
		this.nome_categoria = nome_categoria;
	}

	@Override
	public String toString() {
		return "Categoria [cod_categoria=" + cod_categoria + ", nome_categoria=" + nome_categoria + "]";
	}



}


