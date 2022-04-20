package br.com.rd.pimpolhos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status_pedido")
public class StatusPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codStatus;
	
	@Column(nullable = false)
	private String descricaoStatusPedido;

	
	
	public Integer getCodStatus() {
		return codStatus;
	}

	public void setCodStatus(Integer codStatus) {
		this.codStatus = codStatus;
	}

	public String getDescricaoStatusPedido() {
		return descricaoStatusPedido;
	}

	public void setDescricaoStatusPedido(String descricaoStatusPedido) {
		this.descricaoStatusPedido = descricaoStatusPedido;
	}

	
	
	@Override
	public String toString() {
		return "StatusPedido [codStatus=" + codStatus + ", descricaoStatusPedido=" + descricaoStatusPedido + "]";
	}


	
}
