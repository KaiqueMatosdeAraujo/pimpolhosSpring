package br.com.rd.pimpolhos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_produto;

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
	private String conteudo_produto;
	
	@Column(nullable = false)
	private Integer cod_fornecedor;
	
	@Column(nullable = false)
	private Integer cod_categoria;
	
	@Column(nullable = false)
	private String img_produto;
	
	@Column(nullable = false)
	private Integer cod_marca;

	public Integer getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Integer cod_produto) {
		this.cod_produto = cod_produto;
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

	public String getConteudo_produto() {
		return conteudo_produto;
	}

	public void setConteudo_produto(String conteudo_produto) {
		this.conteudo_produto = conteudo_produto;
	}

	public Integer getCod_fornecedor() {
		return cod_fornecedor;
	}

	public void setCod_fornecedor(Integer cod_fornecedor) {
		this.cod_fornecedor = cod_fornecedor;
	}

	public Integer getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(Integer cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	public String getImg_produto() {
		return img_produto;
	}

	public void setImg_produto(String img_produto) {
		this.img_produto = img_produto;
	}

	public Integer getCod_marca() {
		return cod_marca;
	}

	public void setCod_marca(Integer cod_marca) {
		this.cod_marca = cod_marca;
	}

	@Override
	public String toString() {
		return "Produto [cod_produto=" + cod_produto + ", nome=" + nome + ", preco=" + preco + ", dimensao=" + dimensao + ", material=" + material + ", peso=" + peso + ", conteudo_produto="
				+ conteudo_produto + ", cod_fornecedor=" + cod_fornecedor + ", cod_categoria=" + cod_categoria
				+ ", img_produto=" + img_produto + ", cod_marca=" + cod_marca + "]";
	}
	
	
}