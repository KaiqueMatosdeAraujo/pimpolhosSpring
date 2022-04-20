package br.com.rd.pimpolhos.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_fornecedor;

	
	@Column(nullable = false)
	@Length(max = 20)
	private String nome_fornecedor;


	public Integer getCod_fornecedor() {
		return cod_fornecedor;
	}

	public void setCod_fornecedor(Integer cod_fornecedor) {
		this.cod_fornecedor = cod_fornecedor;
	}


	public String getNome_fornecedor() {
		return nome_fornecedor;
	}

	public void setNome_fornecedor(String nome_fornecedor) {
		this.nome_fornecedor = nome_fornecedor;
	}

	@Override
	public String toString() {
		return "Fornecedor [cod_fornecedor=" + cod_fornecedor + ", nome_fornecedor=" + nome_fornecedor + "]";
	}


	

	

	

}
