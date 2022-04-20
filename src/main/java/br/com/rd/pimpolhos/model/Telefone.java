package br.com.rd.pimpolhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="telefone")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_telefone;
	
	@Column(nullable = false)
	private String ddd;
	
	@Column(nullable = false)
	private String numero_telefone;
	
	@Column(nullable = false)
	private Integer cod_tipo_telefone;

	
	public Integer getCod_telefone() {
		return cod_telefone;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero_telefone() {
		return numero_telefone;
	}

	public Integer getCod_tipo_telefone() {
		return cod_tipo_telefone;
	}

	public void setCod_telefone(Integer cod_telefone) {
		this.cod_telefone = cod_telefone;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public void setNumero_telefone(String numero_telefone) {
		this.numero_telefone = numero_telefone;
	}

	public void setCod_tipo_telefone(Integer cod_tipo_telefone) {
		this.cod_tipo_telefone = cod_tipo_telefone;
	}

	@Override
	public String toString() {
		return "Telefone [cod_telefone" + cod_telefone + ", ddd=" + ddd + 
				", numero_telefone" + numero_telefone + ", cod_tipo_telefone=" + 
				cod_tipo_telefone + "]";
	}
	
}
