package br.com.rd.pimpolhos.PimpolhosSpring.dto;


public class CartaoDTO {

	private String numeroCartao;
	private String nomeTitular;
	
	
	public CartaoDTO(String numeroCartao, String nomeTitular) {
		super();
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
	}


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
	
	
	
	
}
