package br.com.rd.pimpolhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produtosRelacionados")
public class ProdutosRelacionados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_relacionados;

	@Column(nullable = false)
	private Integer cod_produto;

	public Integer getCod_relacionados() {
		return cod_relacionados;
	}

	public void setCod_relacionados(Integer cod_relacionados) {
		this.cod_relacionados = cod_relacionados;
	}

	public Integer getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Integer cod_produto) {
		this.cod_produto = cod_produto;
	}

	@Override
	public String toString() {
		return "ProdutosRelacionados [cod_relacionados=" + cod_relacionados + ", cod_produto=" + cod_produto + "]";
	}
	
}