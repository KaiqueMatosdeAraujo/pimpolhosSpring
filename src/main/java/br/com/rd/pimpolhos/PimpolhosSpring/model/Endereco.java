package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codEndereco;
	
	@Column(nullable = false)
	private String nomeCidade;

	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)

	private String nomeRua;
	
	@Column(nullable = false)
	private String numeroCasa;

	@Column(nullable = true)
	private String complemento;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = true)
	private String pontoReferencia;
	//cod_estado
	
	

	@ManyToMany(mappedBy = "endereco")
	List<Cliente> cliente;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cod_estado")
	private Estado estado;
	
	public Endereco() {
		
	}

	public Endereco(String nomeCidade, String cep, String nomeRua, String numeroCasa,
			String complemento, String bairro, String pontoReferencia, Estado estado) {
		super();
		this.nomeCidade = nomeCidade;
		this.cep = cep;
		this.nomeRua = nomeRua;
		this.numeroCasa = numeroCasa;
		this.complemento = complemento;
		this.bairro = bairro;
		this.pontoReferencia = pontoReferencia;
		this.estado = estado;
	}


	public Integer getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(Integer codEndereco) {
		this.codEndereco = codEndereco;
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

//	public List<Cliente> getCliente() {
//		return cliente;
//	}
//
//	public void setCliente(List<Cliente> cliente) {
//		this.cliente = cliente;
//	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Endereco [codEndereco=" + codEndereco + ", nomeCidade=" + nomeCidade + ", cep=" + cep + ", nomeRua="
				+ nomeRua + ", numeroCasa=" + numeroCasa + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", pontoReferencia=" + pontoReferencia + ", estado=" + estado + "]";
	}

	

	


	
}
