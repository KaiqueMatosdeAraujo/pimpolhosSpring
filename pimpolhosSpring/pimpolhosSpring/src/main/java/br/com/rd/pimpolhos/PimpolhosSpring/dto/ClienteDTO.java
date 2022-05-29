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
	private String ddd;
	private String telefone;
	
	
	public ClienteDTO(Cliente cliente) {
		this.nomeCliente = cliente.getNomeCliente();
		this.cpf = cliente.getCpf();
		this.dataNasc = cliente.getDataNasc();
		this.email = cliente.getEmail();
		this.ddd = cliente.getDdd();
		this.telefone = cliente.getNumeroTelefone();
	
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
	
	

	public String getDdd() {
		return ddd;
	}


	public void setDdd(String ddd) {
		this.ddd = ddd;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public static List<ClienteDTO> converter(List<Cliente> clientes){
		return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
	}

}