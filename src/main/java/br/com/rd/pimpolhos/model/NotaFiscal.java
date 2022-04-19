package br.com.rd.pimpolhos.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

	@Entity
	@Table(name="nf_e")
	public class NotaFiscal {

//		@Id
//		@GeneratedValue(strategy = GenerationType.IDENTITY)
//		private Integer codNf;
		
//		@Column(nullable = false)
//		private Integer codPedido;
		
		@Column(nullable = false)
		private Integer numeroNf;
		
		@Column(nullable = false)
		private String chaveAcesso;
		
		@Column(nullable = false)
		private String dataEmissao;
		
		@Column(nullable = false)
		private Integer valorTotalNf;
		
		@Column(nullable = false)
		private Integer valorTotalProdutos;
		
		@Column(nullable = false)
		private Integer cooNota;
		
		@Column(nullable = false)
		private Integer valorFrete;
		
		@Column(nullable = false)
		private String inscricaEstadual;
		
		@Column(nullable = false)
		private Integer valorIcmsTotal;
		
//		@Column(nullable = false)
//		private Integer codProduto;
		
//		@Column(nullable = false)
//		private Integer codItemNota;
		
//		@Column(nullable = false)
//		private Integer codNaturezaOperacao;
		
		@Column(nullable = false)
		private String cnpjPimpolhos;
		
		@Column(nullable = false)
		private String razaoSocial;

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

		public Integer getValorFrete() {
			return valorFrete;
		}

		public void setValorFrete(Integer valorFrete) {
			this.valorFrete = valorFrete;
		}

		public String getInscricaEstadual() {
			return inscricaEstadual;
		}

		public void setInscricaEstadual(String inscricaEstadual) {
			this.inscricaEstadual = inscricaEstadual;
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
		
}
