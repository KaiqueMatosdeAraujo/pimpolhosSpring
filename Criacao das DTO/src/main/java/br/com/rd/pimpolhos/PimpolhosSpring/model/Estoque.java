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
@Table(name="estoque")
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@OneToMany(fetch = FetchType.EAGER) 
//	@JoinColumn(name="codProduto") 
//	private List<Produto> produto;
	private Integer codProduto;


	
	@Column(nullable = false)
	private Integer quantidade;

	

//	public List<Produto> getProduto() {
//		return produto;
//	}
//
//	public void setProduto(List<Produto> produto) {
//		this.produto = produto;
//	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Estoque [quantidade=" + quantidade + "]";
	}

	

	


	
}
