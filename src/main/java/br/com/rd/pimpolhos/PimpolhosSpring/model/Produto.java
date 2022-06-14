package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.math.BigDecimal;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codProduto;

	@Size(max=50)
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private BigDecimal preco;
		
	@Size(max=50)
	@Column(nullable = true)
	private String dimensao;
	
	@Size(max=50)
	@Column(nullable = false)
	private String material;
	
	@Column(nullable = false)
	private BigDecimal peso;
	
	@Column(nullable = false)
	private String conteudoProduto;
	
	@Column(nullable = false)
	private String imgProduto;
	
	@Column (nullable = false)
	private Integer qtdEstoque;

	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_fornecedor")
	private Fornecedor fornecedor;

	
	@ManyToOne (fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_marca")
	private Marca marca;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_categoria")
	private Categoria categoria;
	
	
	@ManyToMany(mappedBy = "produto")
	List<Cliente> cliente;

	@OneToMany(mappedBy="codProduto")
	private List<ItemPedido> itemPedido;

	public Integer getCodProduto() {
		return codProduto;
	}


	public void setCodProduto(Integer codProduto) {
		this.codProduto = codProduto;
	}


	
	public Integer getQtdEstoque() {
		return qtdEstoque;
	}


	public void setQtdEstoque(Integer qtdEstoque) {
		this.qtdEstoque = qtdEstoque;
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

	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}


	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}


	public Marca getMarca() {
		return marca;
	}


	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}


//	public List<Cliente> getCliente() {
//		return cliente;
//	}
//
//
//	public void setCliente(List<Cliente> cliente) {
//		this.cliente = cliente;
//	}


	@Override
	public String toString() {
		return "Produto [codProduto=" + codProduto + ", nome=" + nome + ", preco=" + preco + ", dimensao=" + dimensao
				+ ", material=" + material + ", peso=" + peso + ", conteudoProduto=" + conteudoProduto + ", imgProduto="
				+ imgProduto + ", fornecedor=" + fornecedor + ", marca=" + marca + ", categoria=" + categoria + "]";
	}





	

	
}