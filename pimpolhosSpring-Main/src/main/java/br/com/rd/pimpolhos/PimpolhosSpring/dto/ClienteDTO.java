package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;

public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String nomeCliente;
	private String cpf;
	private String dataNasc;
	private String email;
	
	
	public ClienteDTO(Cliente cliente) {
		this.nomeCliente = cliente.getNomeCliente();
		this.cpf = cliente.getCpf();
		this.email = cliente.getEmail();
		this.dataNasc = cliente.getDataNasc();
	
	}
	
	
	public ClienteDTO() {}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public String getEmail() {
		return email;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static List<ClienteDTO> converter(List<Cliente> clientes){
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

}
