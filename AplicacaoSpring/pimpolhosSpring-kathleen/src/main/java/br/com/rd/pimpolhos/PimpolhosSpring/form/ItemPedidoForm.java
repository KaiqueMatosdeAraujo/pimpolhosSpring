package br.com.rd.pimpolhos.PimpolhosSpring.form;

import java.util.List;
import java.util.Optional;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.ItemPedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Produto;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ItemPedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ProdutoRepository;

public class ItemPedidoForm {

		private String codPedido;
		private String codProduto;
		
		private String quantidade;


		public ItemPedidoForm(String codPedido , String codProduto, String quantidade) {
			this.codPedido = codPedido;
			this.codProduto = codProduto;
			this.quantidade = quantidade;
		}


		public String getCodPedido() {
			return codPedido;
		}


		public void setCodPedido(String codPedido) {
			this.codPedido = codPedido;
		}


		public String getCodProduto() {
			return codProduto;
		}


		public void setCodProduto(String codProduto) {
			this.codProduto = codProduto;
		}


		public String getQuantidade() {
			return quantidade;
		}


		public void setQuantidade(String quantidade) {
			this.quantidade = quantidade;
		}


	
		
//		public ItemPedido converter(ProdutoRepository produtoRepository , ItemPedidoRepository itemPedidoRepository) {
//			Optional<Produto> produto = produtoRepository.findById(this.codProduto);
//			ItemPedido itemPedido = new ItemPedido(produto.get() , this.quantidade );
//			return itemPedido;
//		}
//		
//		public List<ItemPedidoDTO> cadastrarItemPedido (Pedido pedido , ItemPedido itemPedido , PedidoRepository pedidoRepository){
//			List<ItemPedido>itemPedidos;
//			itemPedidos = (List<ItemPedido>) itemPedido.getCodPedido();
//			itemPedidos.add(itemPedido);
//			pedido.setItemPedido(itemPedido);
//			return ItemPedidoDTO.converter(itemPedidos);
//			
//		}
		
		
}
