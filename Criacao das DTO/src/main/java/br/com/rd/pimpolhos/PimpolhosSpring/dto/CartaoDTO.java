package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import javax.validation.constraints.NotBlank;

public class CartaoDTO {
	
	@NotBlank
	private String numeroCartao;
	
	@NotBlank
	private String nomeTitular;
	
	@NotBlank
	private String validade;

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public String getValidade() {
		return validade;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public CartaoDTO(@NotBlank String numeroCartao, @NotBlank String nomeTitular, @NotBlank String validade) {
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
		this.validade = validade;
	}
}
