package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produtosRelacionados")
public class ProdutosRelacionados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_relacionados;

//	@OneToMany(fetch = FetchType.EAGER) 
//	@JoinColumn(name="codProduto") 
//	private List<Produto> produto; 

	@Column(nullable = false)
	public Integer getCod_relacionados() {
		return cod_relacionados;
	}

	public void setCod_relacionados(Integer cod_relacionados) {
		this.cod_relacionados = cod_relacionados;
	}

//	public List<Produto> getProduto() {
//		return produto;
//	}
//
//	public void setProduto(List<Produto> produto) {
//		this.produto = produto;
//	}
//
//	@Override
//	public String toString() {
//		return "ProdutosRelacionados [cod_relacionados=" + cod_relacionados + ", produto=" + produto + "]";
//	}

}