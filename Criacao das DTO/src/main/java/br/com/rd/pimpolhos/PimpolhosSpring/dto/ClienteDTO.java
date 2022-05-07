package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

public class ClienteDTO {
	
	@NotBlank
	private String nomeCliente;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private LocalDate dataNasc;
	
	@NotBlank
	private String email;

	public String getNomeCliente() {
		return nomeCliente;
	}

	public String getCpf() {
		return cpf;
	}

	public LocalDate getDataNasc() {
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

	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ClienteDTO(@NotBlank String nomeCliente, @NotBlank String cpf, @NotBlank LocalDate dataNasc,
			@NotBlank String email) {
		this.nomeCliente = nomeCliente;
		this.cpf = cpf;
		this.dataNasc = dataNasc;
		this.email = email;
	}

}
