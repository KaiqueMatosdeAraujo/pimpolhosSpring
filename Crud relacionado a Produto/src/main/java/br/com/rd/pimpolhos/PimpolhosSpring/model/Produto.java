package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.math.BigDecimal;

import java.util.List;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProduto;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private BigDecimal preco;
		
	@Column(nullable = true)
	private String dimensao;
	
	@Column(nullable = false)
	private String material;
	
	@Column(nullable = false)
	private BigDecimal peso;
	
	@Column(nullable = false)
	private String conteudoProduto;
	
//	@Column(nullable = false)
//	private Integer codFornecedor;
	
//	@Column(nullable = false)
//	private Integer codCategoria;
	
	@Column(nullable = false)
	private String imgProduto;
	
	//@Column(nullable = false)
	//private Integer codMarca;

	
	@ManyToMany(mappedBy = "produto")
	Set<Cliente> cliente;


	public Integer getCodProduto() {
		return codProduto;
	}


	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public String getDimensao() {
		return dimensao;
	}


	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}


	public String getMaterial() {
		return material;
	}


	public void setMaterial(String material) {
		this.material = material;
	}


	public BigDecimal getPeso() {
		return peso;
	}


	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}


	public String getConteudoProduto() {
		return conteudoProduto;
	}


	public void setConteudoProduto(String conteudoProduto) {
		this.conteudoProduto = conteudoProduto;
	}


//	public Integer getCodFornecedor() {
//		return codFornecedor;
//	}
//
//
//	public void setCodFornecedor(Integer codFornecedor) {
//		this.codFornecedor = codFornecedor;
//	}
//
//
//	public Integer getCodCategoria() {
//		return codCategoria;
//	}
//
//
//	public void setCodCategoria(Integer codCategoria) {
//		this.codCategoria = codCategoria;
//	}


	public String getImgProduto() {
		return imgProduto;
	}


	public void setImgProduto(String imgProduto) {
		this.imgProduto = imgProduto;
	}


//	public Integer getCodMarca() {
//		return codMarca;
//	}
//
//
//	public void setCodMarca(Integer codMarca) {
//		this.codMarca = codMarca;
//	}


	public Set<Cliente> getCliente() {
		return cliente;
	}


	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", nome=" + nome + ", preco=" + preco + ", dimensao=" + dimensao
				+ ", material=" + material + ", peso=" + peso + ", conteudoProduto=" + conteudoProduto + ", imgProduto="
				+ imgProduto + ", cliente=" + cliente + "]";
	}

	
}