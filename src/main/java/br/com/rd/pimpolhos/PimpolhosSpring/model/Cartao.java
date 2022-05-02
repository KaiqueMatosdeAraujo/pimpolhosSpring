package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cartao")
public class Cartao {

	@EmbeddedId
	private FormaPagamentoID formaPagamentoID;
	
	@Column(nullable = false)
	private String numeroCartao;
	
	@Column(nullable = false)
	private String nomeTitular;
	
	@Column(nullable = false)
	private String validade;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "codBandeira") 
	private Bandeira bandeira;

	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "codCliente") 
	private Cliente cliente;

//	@ManyToOne(fetch = FetchType.EAGER) 
//	@JoinColumn(name = "codOperacao") 
//	private TipoPagamento tipoPagamento;

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	@Override
	public String toString() {
		return "Cartao [numeroCartao=" + numeroCartao + ", nomeTitular=" + nomeTitular + ", validade=" + validade + "]";
	}
	
	
	
}
