package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.NotaFiscal;


public class NotaFiscalDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer numeroNf;
	private String chaveAcesso;
	private String dataEmissao;
	private Integer valorTotalNf;
	private Integer valorTotalProdutos;
	private Integer cooNota;
	private Integer valorFreteNf;
	private String inscricaoEstadual;
	private Integer valorIcmsTotal;
	private String cnpjPimpolhos;
	private String razaoSocial;
	//item nf
	private BigDecimal valorUnitario; 
	private BigDecimal valorTotal;
	private Integer quantidade;
	private BigDecimal valorIcmsItem;
	private String naturezaOperacao;
	//pedido
	private Integer pedido;
	private LocalDate dataPedido;
	private String descricaoFrete;
	private BigDecimal valorFretePedido;
	//status pedido
	private String descricaoStatusPedido;
	//item pedido FALTA
	
	//produto
	private String nome;
	private BigDecimal preco;
	private String dimensao;
	private String material;
	private BigDecimal peso;
	private String conteudoProduto;
	private String imgProduto;


	public NotaFiscalDTO(NotaFiscal notaFiscal) {
		this.numeroNf = notaFiscal.getNumeroNf();
		this.chaveAcesso = notaFiscal.getChaveAcesso();
		this.dataEmissao = notaFiscal.getDataEmissao();
		this.valorTotalNf = notaFiscal.getValorTotalNf();
		this.valorTotalProdutos = notaFiscal.getValorTotalProdutos();
		this.cooNota = notaFiscal.getCooNota();
		this.valorFreteNf = notaFiscal.getValorFrete();
		this.inscricaoEstadual = notaFiscal.getInscricaoEstadual();
		this.valorIcmsTotal = notaFiscal.getValorIcmsTotal();
		this.cnpjPimpolhos = notaFiscal.getCnpjPimpolhos();
		this.razaoSocial = notaFiscal.getRazaoSocial();
		this.valorUnitario = notaFiscal.getItemNf().getValorUnitario();
		this.valorTotal = notaFiscal.getItemNf().getValorTotal();
		this.quantidade = notaFiscal.getItemNf().getQuantidade();
		this.valorIcmsItem = notaFiscal.getItemNf().getValorIcmsItem();
		this.naturezaOperacao = notaFiscal.getNaturezaOperacao().getDescricao_natureza_operacao();
		this.pedido = notaFiscal.getPedido().getCodPedido();
		this.dataPedido = notaFiscal.getPedido().getDataPedido();
		this.descricaoFrete = notaFiscal.getPedido().getFrete().getDescricaoFrete();
		this.valorFretePedido = notaFiscal.getPedido().getFrete().getValorFrete();
		this.descricaoStatusPedido = notaFiscal.getPedido().getStatusPedido().getDescricaoStatusPedido();
	}
	
	
	public NotaFiscalDTO() {}


	public Integer getNumeroNf() {
		return numeroNf;
	}


	public void setNumeroNf(Integer numeroNf) {
		this.numeroNf = numeroNf;
	}


	public String getChaveAcesso() {
		return chaveAcesso;
	}


	public void setChaveAcesso(String chaveAcesso) {
		this.chaveAcesso = chaveAcesso;
	}


	public String getDataEmissao() {
		return dataEmissao;
	}


	public void setDataEmissao(String dataEmissao) {
		this.dataEmissao = dataEmissao;
	}


	public Integer getValorTotalNf() {
		return valorTotalNf;
	}


	public void setValorTotalNf(Integer valorTotalNf) {
		this.valorTotalNf = valorTotalNf;
	}


	public Integer getValorTotalProdutos() {
		return valorTotalProdutos;
	}


	public void setValorTotalProdutos(Integer valorTotalProdutos) {
		this.valorTotalProdutos = valorTotalProdutos;
	}


	public Integer getCooNota() {
		return cooNota;
	}


	public void setCooNota(Integer cooNota) {
		this.cooNota = cooNota;
	}


	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}


	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}


	public Integer getValorIcmsTotal() {
		return valorIcmsTotal;
	}


	public void setValorIcmsTotal(Integer valorIcmsTotal) {
		this.valorIcmsTotal = valorIcmsTotal;
	}


	public String getCnpjPimpolhos() {
		return cnpjPimpolhos;
	}


	public void setCnpjPimpolhos(String cnpjPimpolhos) {
		this.cnpjPimpolhos = cnpjPimpolhos;
	}


	public String getRazaoSocial() {
		return razaoSocial;
	}


	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}


	public String getNaturezaOperacao() {
		return naturezaOperacao;
	}


	public void setNaturezaOperacao(String naturezaOperacao) {
		this.naturezaOperacao = naturezaOperacao;
	}


	public Integer getPedido() {
		return pedido;
	}


	public void setPedido(Integer pedido) {
		this.pedido = pedido;
	}

	
	

	public BigDecimal getValorUnitario() {
		return valorUnitario;
	}


	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}


	public BigDecimal getValorTotal() {
		return valorTotal;
	}


	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}


	public BigDecimal getValorIcmsItem() {
		return valorIcmsItem;
	}


	public void setValorIcmsItem(BigDecimal valorIcmsItem) {
		this.valorIcmsItem = valorIcmsItem;
	}

	
	

	public Integer getValorFreteNf() {
		return valorFreteNf;
	}


	public void setValorFreteNf(Integer valorFreteNf) {
		this.valorFreteNf = valorFreteNf;
	}


	public LocalDate getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}


	public String getDescricaoFrete() {
		return descricaoFrete;
	}


	public void setDescricaoFrete(String descricaoFrete) {
		this.descricaoFrete = descricaoFrete;
	}


	public BigDecimal getValorFretePedido() {
		return valorFretePedido;
	}


	public void setValorFretePedido(BigDecimal valorFretePedido) {
		this.valorFretePedido = valorFretePedido;
	}


	public String getDescricaoStatusPedido() {
		return descricaoStatusPedido;
	}


	public void setDescricaoStatusPedido(String descricaoStatusPedido) {
		this.descricaoStatusPedido = descricaoStatusPedido;
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


	public static List<NotaFiscalDTO> converter(List<NotaFiscal> notas) { 
		return notas.stream().map(NotaFiscalDTO::new).collect(Collectors.toList()); 
	} 
	
}