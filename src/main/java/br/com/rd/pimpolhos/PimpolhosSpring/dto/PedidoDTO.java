package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;

public class PedidoDTO {

//	private ProdutoDTO nomeProduto;
//	private Integer quantidade;
//	private BigDecimal preco;
	private List<ItemPedido> itemPedido;
	private BigDecimal valorFrete;
	//não tem valor total
	
	
	public PedidoDTO(Pedido pedido) {
		this.itemPedido = pedido.getItemPedido();
		this.valorFrete = pedido.getFrete().getValorFrete();
	}


	public List<ItemPedidoDTO> getItemPedido() {
		List<ItemPedidoDTO> itemPedidoConvertido = ItemPedidoDTO.converter(itemPedido);
		return itemPedidoConvertido;
	}


	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}


	public BigDecimal getValorFrete() {
		return valorFrete;
	}


	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}
	
	
	public static List<PedidoDTO> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
}
