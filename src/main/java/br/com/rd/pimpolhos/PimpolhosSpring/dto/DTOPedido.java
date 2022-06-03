package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;

public class DTOPedido {

	private Integer codPedido;
	private String statusPedido;
	private LocalDate dataPedido;
	private String formaPagamento;
	
	public DTOPedido(Pedido pedido) {
		this.codPedido = pedido.getCodPedido();
		this.statusPedido = pedido.getStatusPedido().getDescricaoStatusPedido();
		this.dataPedido = pedido.getDataPedido();
		this.formaPagamento = pedido.getPagamento().getFormaPagamento().getDescricao();
	}

	public DTOPedido() {}
	
	
	
	public Integer getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
	
	public static List<DTOPedido> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(DTOPedido::new).collect(Collectors.toList());
	}
}