package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedidoID;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedidoID;

public class ItemPedidoDTO {
	
		private ItemPedidoID itemPedidoId;
		 
		 private Integer quantidade;
		 
		 

		public ItemPedidoDTO(ItemPedido itemPedido) {
			this.itemPedidoId = itemPedido.getItemPedidoId();
//			this.codPedido = itemPedido.;
//			this.codProduto = itemPedido.getCodProduto().getCodProduto();
			this.quantidade = itemPedido.getQuantidade();
		}
		
		

		public ItemPedidoID getItemPedidoId() {
			return itemPedidoId;
		}



		public void setItemPedidoId(ItemPedidoID itemPedidoId) {
			this.itemPedidoId = itemPedidoId;
		}





		public Integer getQuantidade() {
			return quantidade;
		}

		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}
		 
		public static List<ItemPedidoDTO> converter(List<ItemPedido> itemPedidos) {
			return itemPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
		}
		 
		
		
}