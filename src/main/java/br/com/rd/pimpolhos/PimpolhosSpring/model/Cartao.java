package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cartao")
public class Cartao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCartao;
	
	@Column(nullable = false)
	private String numeroCartao;
	
	@Column(nullable = false)
	private String nomeTitular;
	
	@Column(nullable = false)
	private String validade;
	
	@ManyToOne(fetch = FetchType.EAGER) 
	@JoinColumn(name = "codBandeira") 
	private Bandeira bandeira;

	@JsonIgnore
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

	
	
	public Integer getIdCartao() {
		return idCartao;
	}

	public void setIdCartao(Integer idCartao) {
		this.idCartao = idCartao;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cartao [numeroCartao=" + numeroCartao + ", nomeTitular=" + nomeTitular + ", validade=" + validade + "]";
	}
	
	
	
}
