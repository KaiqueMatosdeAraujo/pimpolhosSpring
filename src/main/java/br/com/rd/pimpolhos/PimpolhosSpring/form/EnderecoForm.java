package br.com.rd.pimpolhos.PimpolhosSpring.form;

import java.util.List;
import java.util.Optional;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.EnderecoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Estado;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EstadoRepository;

public class EnderecoForm {

	private String nomeCidade;
	private String cep;
	private String nomeRua;
	private String numeroCasa;
	private String complemento;
	private String bairro;
	private String pontoReferencia;
	private Integer estado;
	//private String codCliente;
	
	
//	public EnderecoForm(String nomeCidade, String cep, String nomeRua, String numeroCasa, String complemento,
//			String bairro, String pontoReferencia, String codCliente) {
//		super();
//		this.nomeCidade = nomeCidade;
//		this.cep = cep;
//		this.nomeRua = nomeRua;
//		this.numeroCasa = numeroCasa;
//		this.complemento = complemento;
//		this.bairro = bairro;
//		this.pontoReferencia = pontoReferencia;
//		this.codCliente = codCliente;
//	}

	public EnderecoForm(String nomeCidade, String cep, String nomeRua, String numeroCasa, String complemento, String bairro, String pontoReferencia, String estado) {
		this.nomeCidade = nomeCidade;
		this.cep = cep;
		this.nomeRua = nomeRua;
		this.numeroCasa = numeroCasa;
		this.complemento = complemento;
		this.bairro = bairro;
		this.pontoReferencia = pontoReferencia;
		this.estado = Integer.parseInt(estado);
	}

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


//	public String getCodCliente() {
//		return codCliente;
//	}
//
//
//	public void setCodCliente(String codCliente) {
//		this.codCliente = codCliente;
//	}
	
	
	
	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Endereco converter(EstadoRepository estadoRepository) {
		Endereco endereco = new Endereco(nomeCidade, cep, nomeRua, numeroCasa, complemento, bairro, pontoReferencia);
		Optional<Estado> estado = estadoRepository.findById(this.estado);
		endereco.setEstado(estado.get());
		return endereco;
		
	}
	
	public List<EnderecoDTO> cadastrar(Endereco endereco, Cliente cliente, ClienteRepository clienteRepository){
		List<Endereco> enderecos;
		enderecos = cliente.getEndereco();
		enderecos.add(endereco);
		cliente.setEndereco(enderecos);
		clienteRepository.save(cliente);
		return EnderecoDTO.converter(enderecos);
	}
	
}
