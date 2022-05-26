package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;

public class EnderecoDTO {

	private Integer codEndereco;
	private String nomeCidade;
	private String cep;
	private String nomeRua;
	private String numeroCasa;
	private String complemento;
	private String bairro;
	private String pontoReferencia;
	private String estado;
	
	//private List<Cliente> cliente;
	
	
	public EnderecoDTO(Endereco endereco) {
		//this.codEndereco = endereco.getCodEndereco();
		this.nomeCidade = endereco.getNomeCidade();
		this.cep = endereco.getCep();
		this.nomeRua = endereco.getNomeRua();
		this.numeroCasa = endereco.getNumeroCasa();
		this.complemento = endereco.getComplemento();
		this.bairro = endereco.getBairro();
		this.pontoReferencia = endereco.getPontoReferencia();
		this.estado = endereco.getEstado().getDescricao_estado();
		//this.cliente = endereco.getCliente();
	}
	
	public EnderecoDTO() {}

//	public Integer getCodEndereco() {
//		return codEndereco;
//	}
//
//
//	public void setCodEndereco(Integer codEndereco) {
//		this.codEndereco = codEndereco;
//	}


	public String getNomeCidade() {
		return nomeCidade;
	}


	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}


	public String getCep() {
		return cep;
	}


	public void setCep(String cep) {
		this.cep = cep;
	}


	public String getNomeRua() {
		return nomeRua;
	}


	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}


	public String getNumeroCasa() {
		return numeroCasa;
	}


	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}


	public String getComplemento() {
		return complemento;
	}


	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}


	public String getBairro() {
		return bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getPontoReferencia() {
		return pontoReferencia;
	}


	public void setPontoReferencia(String pontoReferencia) {
		this.pontoReferencia = pontoReferencia;
	}


//	public List<ClienteDTO> getCliente() {
//		List<ClienteDTO> clienteConvertido = ClienteDTO.converter(cliente);
//		return clienteConvertido;
//	}
//
//
//	public void setCliente(List<Cliente> cliente) {
//		this.cliente = cliente;
//	}
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public static List<EnderecoDTO> converter(List<Endereco> enderecos){
		return enderecos.stream().map(EnderecoDTO::new).collect(Collectors.toList());
	}
}
