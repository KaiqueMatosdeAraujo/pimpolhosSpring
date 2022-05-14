package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Frete;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.StatusPedido;

public class PedidoDTO {
	
	
	private Integer codPedido;
	
	
	private Date dataPedido;
	
	


 
	private Frete frete; 
	
	
	private StatusPedido statusPedido; 
	
	
	private List<ItemPedido> itemPedido;
	

	private Pagamento pagamento;


	public PedidoDTO(Pedido pedido) {

		this.codPedido = pedido.getCodPedido();
		this.dataPedido = pedido.getDataPedido();
		this.frete = pedido.getFrete();
		this.statusPedido = pedido.getStatusPedido();
		this.itemPedido = pedido.getItemPedido();
		this.pagamento = pedido.getPagamento();
	}


	public Integer getCodPedido() {
		return codPedido;
	}


	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}


	public String getDataPedido() {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String data = formato.format(dataPedido);
		return data;
	}


	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}



	public Frete getFrete() {
		return frete;
	}


	public void setFrete(Frete frete) {
		this.frete = frete;
	}


	public StatusPedido getStatusPedido() {
		return statusPedido;
	}


	public void setStatusPedido(StatusPedido statusPedido) {
		this.statusPedido = statusPedido;
	}


	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}


	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}


	public Pagamento getPagamento() {
		return pagamento;
	}


	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public static List<PedidoDTO> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}

	
	
}
