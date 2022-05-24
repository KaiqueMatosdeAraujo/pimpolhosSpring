package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Telefone;

public class TelefoneDTO {
	
	private Integer codTelefone;
	private String ddd;
	private String numeroTelefone;
	private String descricaoTelefone;
	
	private List<Cliente> nomeCliente;
	


	public TelefoneDTO(Telefone telefone) {
		this.ddd = telefone.getDdd();
		this.numeroTelefone = telefone.getNumero_telefone();
		this.descricaoTelefone = telefone.getDescricao_telefone();
		this.nomeCliente = telefone.getCliente();
	}

	public Integer getCodTelefone() {
		return codTelefone;
	}

	public void setCodTelefone(Integer codTelefone) {
		this.codTelefone = codTelefone;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(String numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public String getDescricaoCliente() {
		return descricaoTelefone;
	}

	public void setDescricaoCliente(String descricaoTelefone) {
		this.descricaoTelefone = descricaoTelefone;
	}

	public List<Cliente> getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(List<Cliente> nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public static List<TelefoneDTO> converter(List<Telefone> enderecos){
		return enderecos.stream().map(TelefoneDTO::new).collect(Collectors.toList());
	}
	
}
