package br.com.rd.pimpolhos.model;

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
	private Integer cod_endereco;
	
	@Column(nullable = false)
	private String nome_cidade;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String nome_rua;
	
	@Column(nullable = false)
	private String numero_casa;
	
	@Column(nullable = true)
	private String complemento;
	
	@Column(nullable = false)
	private String bairo;
	
	@Column(nullable = true)
	private String ponto_referencia;
	//cod_estado
	
	

	public Integer getCod_endereco() {
		return cod_endereco;
	}

	public void setCod_endereco(Integer cod_endereco) {
		this.cod_endereco = cod_endereco;
	}

	public String getNome_cidade() {
		return nome_cidade;
	}

	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNome_rua() {
		return nome_rua;
	}

	public void setNome_rua(String nome_rua) {
		this.nome_rua = nome_rua;
	}

	public String getNumero_casa() {
		return numero_casa;
	}

	public void setNumero_casa(String numero_casa) {
		this.numero_casa = numero_casa;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairo() {
		return bairo;
	}

	public void setBairo(String bairo) {
		this.bairo = bairo;
	}

	public String getPonto_referencia() {
		return ponto_referencia;
	}

	public void setPonto_referencia(String ponto_referencia) {
		this.ponto_referencia = ponto_referencia;
	}

	
	@Override
	public String toString() {
		return "Endereco [cod_endereco=" + cod_endereco + ", nome_cidade=" + nome_cidade + ", cep=" + cep
				+ ", nome_rua=" + nome_rua + ", numero_casa=" + numero_casa + ", complemento=" + complemento
				+ ", bairo=" + bairo + ", ponto_referencia=" + ponto_referencia + "]";
	}
	
	
	
	
}
