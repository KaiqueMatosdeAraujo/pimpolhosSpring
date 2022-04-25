package br.com.rd.pimpolhos.PimpolhosSpring.model;

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
@Table(name="telefone")
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
	
	@Column(nullable = false)
	private String descricao_telefone;
	
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "cod_tipo_telefone")
//	private TipoTelefone tipoTelefone;
	
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

	public Set<Cliente> getCliente() {
		return cliente;
	}

	public void setCliente(Set<Cliente> cliente) {
		this.cliente = cliente;
	}

	public String getDescricao_telefone() {
		return descricao_telefone;
	}

	public void setDescricao_telefone(String descricao_telefone) {
		this.descricao_telefone = descricao_telefone;
	}

	@Override
	public String toString() {
		return "Telefone [cod_telefone=" + cod_telefone + ", ddd=" + ddd + ", numero_telefone=" + numero_telefone
				+ ", cliente=" + cliente + ", descricao_telefone=" + descricao_telefone + "]";
	}

	

//	public TipoTelefone getTipoTelefone() {
//		return tipoTelefone;
//	}
//
//	public void setTipoTelefone(TipoTelefone tipoTelefone) {
//		this.tipoTelefone = tipoTelefone;
//	}

	

}
