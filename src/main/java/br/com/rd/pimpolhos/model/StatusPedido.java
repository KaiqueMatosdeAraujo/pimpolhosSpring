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
	private Integer cod_status;
	
	@Column(nullable = false)
	private String descricao_status_pedido;

	
	
	public Integer getCod_status() {
		return cod_status;
	}

	public void setCod_status(Integer cod_status) {
		this.cod_status = cod_status;
	}

	public String getDescricao_status_pedido() {
		return descricao_status_pedido;
	}

	public void setDescricao_status_pedido(String descricao_status_pedido) {
		this.descricao_status_pedido = descricao_status_pedido;
	}

	
	@Override
	public String toString() {
		return "StatusPedido [cod_status=" + cod_status + ", descricao_status_pedido=" + descricao_status_pedido + "]";
	}
	

	
}
