package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;

public class TokenDTO {
	
	private Integer codCliente;
	private String nome;
	private String token;
	private String tipo;
	
	public TokenDTO(Cliente cliente , String token, String tipo) {
		this.codCliente = cliente.getCodCliente();
		this.nome = cliente.getNomeCliente();
		this.token = token;
		this.tipo = tipo;
		
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

	
}
