package br.com.rd.pimpolhos.model;

import java.util.Set;

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
@Table(name="telefones")
public class Telefone {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_telefone;
	
	@Column(nullable = false)
	private String ddd;
	
	@Column(nullable = false)
	private String numero_telefone;
	

	@ManyToMany(mappedBy = "telefone")
	Set<Cliente> cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tipoTelefone")
	private TipoTelefone tipoTelefone;
	
	public Integer getCod_telefone() {
		return cod_telefone;
	}

	public String getDdd() {
		return ddd;
	}

	public String getNumero_telefone() {
		return numero_telefone;
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

	

	@Override
	public String toString() {
		return "Telefone [cod_telefone" + cod_telefone + ", ddd=" + ddd + 
				", numero_telefone" + numero_telefone + "]";
	}
	
}
