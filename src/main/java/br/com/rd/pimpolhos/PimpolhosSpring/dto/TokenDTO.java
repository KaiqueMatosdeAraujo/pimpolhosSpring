package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.util.List;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;

public class TokenDTO {
	
	private Integer codCliente;
	private String nome;
	private String token;
	private String tipo;
	private List<Endereco> endereco;
	
	public TokenDTO(Cliente cliente , String token, String tipo) {
		this.codCliente = cliente.getCodCliente();
		this.nome = cliente.getNomeCliente();
		this.token = token;
		this.tipo = tipo;
		this.endereco = cliente.getEndereco();
		
	}


	


	public Integer getcodCliente() {
		return codCliente;
	}





	public String getNome() {
		return nome;
	}





	public String getToken() {
		return token;
	}

	public String getTipo() {
		return tipo;
	}





	public List<Endereco> getEndereco() {
		return endereco;
	}





	
	
}
