package br.com.rd.pimpolhos.PimpolhosSpring.model;

import java.util.List;
import java.util.stream.Collectors;

public class PedidoTeste {

	private String descricaoFrete;
	private String tipoPagamento;
	private String descricaoStatusPedido;
	
	public PedidoTeste(Pedido pedido) {
		this.descricaoFrete = pedido.getFrete().getDescricaoFrete();
		this.tipoPagamento = pedido.getPagamento().getFormaPagamento().getDescricao();
		this.descricaoStatusPedido = pedido.getStatusPedido().getDescricaoStatusPedido();
	}

	public String getDescricaoFrete() {
		return descricaoFrete;
	}

	public void setDescricaoFrete(String descricaoFrete) {
		this.descricaoFrete = descricaoFrete;
	}

	public String getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public String getDescricaoStatusPedido() {
		return descricaoStatusPedido;
	}

	public void setDescricaoStatusPedido(String descricaoStatusPedido) {
		this.descricaoStatusPedido = descricaoStatusPedido;
	}
	
	public static List<PedidoTeste> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoTeste::new).collect(Collectors.toList());
		} 
	
}
