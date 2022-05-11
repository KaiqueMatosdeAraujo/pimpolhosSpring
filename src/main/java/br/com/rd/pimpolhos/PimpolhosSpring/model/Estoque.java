package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="estoque")
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idEstoque;

    @ManyToOne
    @JoinColumn(name = "codProduto",unique=true,nullable=false)
    private Produto produtos;
	
	@Column(nullable = false)
	private Integer quantidade;

	public Integer getIdEstoque() {
		return idEstoque;
	}

	public void setIdEstoque(Integer idEstoque) {
		this.idEstoque = idEstoque;
	}

	public Produto getProdutos() {
		return produtos;
	}

	public void setProdutos(Produto produtos) {
		this.produtos = produtos;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
	public String toString() {
		return "Estoque [idEstoque=" + idEstoque + ", produtos=" + produtos + ", quantidade=" + quantidade + "]";
	}

	



	


	
}
