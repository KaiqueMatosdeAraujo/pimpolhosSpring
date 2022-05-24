package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Produto;

public class ProdutoDTO {
	
	private Integer codProduto;
	private String nome;
	private BigDecimal preco;
	private String imgProduto;
	private String nomeCategoria;
	
	public ProdutoDTO(Produto produto) {
		this.codProduto = produto.getCodProduto();
		this.nome = produto.getNome();
		this.preco = produto.getPreco();
		this.imgProduto = produto.getImgProduto();
		this.nomeCategoria = produto.getCategoria().getNome_categoria();
	}

	public Integer getCodProduto() {
		return codProduto;
	}

	public String getNome() {
		return nome;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getImgProduto() {
		return imgProduto;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}
	
	
	public static List<ProdutoDTO> converter(List<Produto> categorias){
		return categorias.stream().map(ProdutoDTO::new).collect(Collectors.toList());
	}
	
	
}
