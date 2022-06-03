package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;

public class CartaoDTO {

	private Integer codCartao;
	private String numeroCartao;
	private String nomeTitular;
	private String nomeCliente;
	
	
	public CartaoDTO(Cartao cartao) {
		this.codCartao = cartao.getCodCartao();
		this.numeroCartao = cartao.getNumeroCartao();
		this.nomeTitular = cartao.getNomeTitular();
		this.nomeCliente = cartao.getCliente().getNomeCliente();
	}

	
	public CartaoDTO() {}
	
	

	public Integer getCodCartao() {
		return codCartao;
	}


	public void setCodCartao(Integer codCartao) {
		this.codCartao = codCartao;
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
	
	
	
	
	public String getNomeCliente() {
		return nomeCliente;
	}


	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}


	public static List<CartaoDTO> converter(List<Cartao> cartoes){
		return cartoes.stream().map(CartaoDTO::new).collect(Collectors.toList());
	}
	
}
