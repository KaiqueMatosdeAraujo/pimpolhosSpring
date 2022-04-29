package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="pesquisa_satisfacao")
public class PesquisaSatisfacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_pesquisa;

	
	@Column(nullable = false)
	@Length(max = 20)
	private String descricao_pesquisa_satisfacao;


	public Integer getCod_pesquisa() {
		return cod_pesquisa;
	}

	public void setCod_pesquisa(Integer cod_pesquisa) {
		this.cod_pesquisa = cod_pesquisa;
	}


	public String getDescricao_pesquisa_satisfacao() {
		return descricao_pesquisa_satisfacao;
	}

	public void setDescricao_pesquisa_satisfacao(String descricao_pesquisa_satisfacao) {
		this.descricao_pesquisa_satisfacao = descricao_pesquisa_satisfacao;
	}

	@Override
	public String toString() {
		return "PesquisaSatisfacao [cod_pesquisa=" + cod_pesquisa + ", descricao_pesquisa_satisfacao="
				+ descricao_pesquisa_satisfacao + "]";
	}

}
