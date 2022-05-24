package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;

public class CartaoDTO {

	private String numeroCartao;
	private String nomeTitular;
	private String bandeira;
//	private String nomeCliente;
//	private String cpfCliente;
//	private LocalDate dataNasc;
	
	public CartaoDTO(Cartao cartao) {
		this.numeroCartao = cartao.getNumeroCartao();
		this.nomeTitular = cartao.getNomeTitular();
		this.bandeira = cartao.getBandeira().getDescricaoBandeira();
//		this.nomeCliente = cartao.getCliente().getNomeCliente();
//		this.cpfCliente = cartao.getCliente().getCpf();
//		this.dataNasc = cartao.getCliente().getDataNasc();
	}

	
	public CartaoDTO() {}

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
	



	public String getBandeira() {
		return bandeira;
	}


//	public String getNomeCliente() {
//		return nomeCliente;
//	}
//
//
//	public void setNomeCliente(String nomeCliente) {
//		this.nomeCliente = nomeCliente;
//	}


	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}
	
	


//	public String getCpfCliente() {
//		return cpfCliente;
//	}
//
//
//	public void setCpfCliente(String cpfCliente) {
//		this.cpfCliente = cpfCliente;
//	}
//
//	
//
//	public LocalDate getDataNasc() {
//		return dataNasc;
//	}
//
//
//	public void setDataNasc(LocalDate dataNasc) {
//		this.dataNasc = dataNasc;
//	}


	public static List<CartaoDTO> converter(List<Cartao> cartao){
		return cartao.stream().map(CartaoDTO::new).collect(Collectors.toList());
	}
	
}
