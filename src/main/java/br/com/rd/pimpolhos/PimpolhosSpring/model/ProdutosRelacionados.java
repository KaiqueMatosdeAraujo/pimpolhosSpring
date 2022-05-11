package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.util.List;
<<<<<<< HEAD
import java.util.Set;

import javax.persistence.CascadeType;
=======

>>>>>>> b9592ee39813d8c4fb4b1c4570ca2d86ecb20bc2
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
<<<<<<< HEAD
import javax.persistence.ManyToMany;
=======
>>>>>>> b9592ee39813d8c4fb4b1c4570ca2d86ecb20bc2
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="produtosRelacionados")
public class ProdutosRelacionados {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_relacionados;

<<<<<<< HEAD
	@OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name="codProduto")
	private List<Produto> produto;
=======
//	@OneToMany
//	@JoinColumn(name="codProduto") 
//	private List<Produto> produto; 
>>>>>>> b9592ee39813d8c4fb4b1c4570ca2d86ecb20bc2

	public Integer getCod_relacionados() {
		return cod_relacionados;
	}

	public void setCod_relacionados(Integer cod_relacionados) {
		this.cod_relacionados = cod_relacionados;
	}

<<<<<<< HEAD


	public List<Produto> getProduto() {
		return produto;
	}

	public void setProduto(List<Produto> produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "ProdutosRelacionados [cod_relacionados=" + cod_relacionados + ", cod_produto=" + produto + "]";
	}




	
	

=======
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

>>>>>>> b9592ee39813d8c4fb4b1c4570ca2d86ecb20bc2
}