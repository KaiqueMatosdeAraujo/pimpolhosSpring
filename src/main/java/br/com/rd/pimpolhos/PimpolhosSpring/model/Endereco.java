package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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


	@Override
	public String toString() {
		return "Endereco [codEndereco=" + codEndereco + ", nomeCidade=" + nomeCidade + ", cep=" + cep + ", nomeRua="
				+ nomeRua + ", numeroCasa=" + numeroCasa + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", pontoReferencia=" + pontoReferencia + "]";
	}

	
}
