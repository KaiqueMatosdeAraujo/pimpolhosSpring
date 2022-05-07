package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;

public class ProdutoDTO {
	
	@NotBlank
	private Integer codProduto;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private BigDecimal preco;
	
	@NotBlank
	private String dimensao;
	
	@NotBlank
	private String material;
	
	@NotBlank
	private BigDecimal peso;
	
	@NotBlank
	private String conteudoProduto;
	
	@NotBlank
	private String imgProduto;
	
	public Integer getCodProduto() {
		return codProduto;
	}
	public String getNome() {
		return nome;
	}
	public BigDecimal getPreco() {
		return preco;
	}
	public String getDimensao() {
		return dimensao;
	}
	public String getMaterial() {
		return material;
	}
	public BigDecimal getPeso() {
		return peso;
	}
	public String getConteudoProduto() {
		return conteudoProduto;
	}
	public String getImgProduto() {
		return imgProduto;
	}
	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}
	public void setDimensao(String dimensao) {
		this.dimensao = dimensao;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}
	public void setConteudoProduto(String conteudoProduto) {
		this.conteudoProduto = conteudoProduto;
	}
	public void setImgProduto(String imgProduto) {
		this.imgProduto = imgProduto;
	}
	
	public ProdutoDTO(Integer codProduto, String nome, BigDecimal preco, String dimensao, String material,
			BigDecimal peso, String conteudoProduto, String imgProduto) {
		this.codProduto = codProduto;
		this.nome = nome;
		this.preco = preco;
		this.dimensao = dimensao;
		this.material = material;
		this.peso = peso;
		this.conteudoProduto = conteudoProduto;
		this.imgProduto = imgProduto;
	}
	
}
