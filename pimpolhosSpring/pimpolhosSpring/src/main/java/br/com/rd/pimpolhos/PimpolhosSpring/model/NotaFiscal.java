package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

	@Entity
	@Table(name="nf_e")
	public class NotaFiscal {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer codNf;

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
		private String inscricaoEstadual;
		
		@Column(nullable = false)
		private Integer valorIcmsTotal;
		
		@Column(nullable = false)
		private String cnpjPimpolhos;
		
		@Column(nullable = false)
		private String razaoSocial;

		@ManyToOne
		@JoinColumns(value ={
				@JoinColumn(name = "codItemNota"),
				@JoinColumn(name = "codProduto")})
		private ItemNf itemNf; 
		
		@ManyToOne
		@JoinColumn(name="cod_natureza_operacao")
		private NaturezaOperacao naturezaOperacao;
		
		@OneToOne
		@JoinColumn(name="codPedido")
		private Pedido pedido;
		
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

		public String getInscricaoEstadual() {
			return inscricaoEstadual;
		}

		public void setInscricaoEstadual(String inscricaEstadual) {
			this.inscricaoEstadual = inscricaEstadual;
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
		
		

		public Integer getCodNf() {
			return codNf;
		}

		public void setCodNf(Integer codNf) {
			this.codNf = codNf;
		}

		public ItemNf getItemNf() {
			return itemNf;
		}

		public void setItemNf(ItemNf itemNf) {
			this.itemNf = itemNf;
		}

		public NaturezaOperacao getNaturezaOperacao() {
			return naturezaOperacao;
		}

		public void setNaturezaOperacao(NaturezaOperacao naturezaOperacao) {
			this.naturezaOperacao = naturezaOperacao;
		}

		public Pedido getPedido() {
			return pedido;
		}

		public void setPedido(Pedido pedido) {
			this.pedido = pedido;
		}

		@Override
		public String toString() {
			return "NotaFiscal [codNf=" + codNf + ", numeroNf=" + numeroNf + ", chaveAcesso=" + chaveAcesso
					+ ", dataEmissao=" + dataEmissao + ", valorTotalNf=" + valorTotalNf + ", valorTotalProdutos="
					+ valorTotalProdutos + ", cooNota=" + cooNota + ", valorFrete=" + valorFrete
					+ ", inscricaoEstadual=" + inscricaoEstadual + ", valorIcmsTotal=" + valorIcmsTotal
					+ ", cnpjPimpolhos=" + cnpjPimpolhos + ", razaoSocial=" + razaoSocial + ", itemNf=" + itemNf
					+ ", naturezaOperacao=" + naturezaOperacao + ", pedido=" + pedido + "]";
		}
		
		
		
}
