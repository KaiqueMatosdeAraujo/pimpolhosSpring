package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Produto;

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
	
	private String marca;
	private String fornecedor;
	private String categoria;
	
	
	public ProdutoDTO (Produto produto) {
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.dimensao = produto.getDimensao();
		this.material = produto.getMaterial();
		this.peso = produto.getPeso();
		this.conteudoProduto = produto.getConteudoProduto();
		this.imgProduto = produto.getImgProduto();
		this.marca = produto.getMarca().getNome_marca();
		this.fornecedor = produto.getFornecedor().getNome_fornecedor();
		this.categoria = produto.getCategoria().getNome_categoria();
	}


	


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


	public String getImgProduto() {
		return imgProduto;
	}


	public void setImgProduto(String imgProduto) {
		this.imgProduto = imgProduto;
	}

	
	public String getMarca() {
		return marca;
	}


	public void setMarca(String marca) {
		this.marca = marca;
	}


	public String getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public static List<ProdutoDTO> converter(List<Produto> produtos) {
		return produtos.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}

}
