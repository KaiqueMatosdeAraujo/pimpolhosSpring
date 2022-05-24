package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedidoID;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Produto;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedidoID;

public class ItemPedidoDTO {
	
		private ItemPedidoID itemPedidoId;
		 
		private Integer quantidade;
		private String nomeProduto;
		private BigDecimal preco;
		private String dimensao;
		private String material;
		private BigDecimal peso;
		private String conteudoProduto;
		private String imgProduto;
		private String marca;
		private String fornecedor;
		private String categoria;


		public ItemPedidoDTO(ItemPedido itemPedido) {
			this.itemPedidoId = itemPedido.getItemPedidoId();
			this.nomeProduto = itemPedido.getCodProduto().getNome();
			this.preco = itemPedido.getCodProduto().getPreco();
			this.dimensao = itemPedido.getCodProduto().getDimensao();
			this.material = itemPedido.getCodProduto().getMaterial();
			this.peso = itemPedido.getCodProduto().getPeso();
			this.conteudoProduto = itemPedido.getCodProduto().getConteudoProduto();
			this.imgProduto = itemPedido.getCodProduto().getImgProduto();
			this.marca = itemPedido.getCodProduto().getMarca().getNome_marca();
			this.fornecedor = itemPedido.getCodProduto().getFornecedor().getNome_fornecedor();
			this.categoria = itemPedido.getCodProduto().getCategoria().getNome_categoria();
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
		
		
		
		 
		public String getNomeProduto() {
			return nomeProduto;
		}



		public void setNomeProduto(String nomeProduto) {
			this.nomeProduto = nomeProduto;
		}



		public BigDecimal getPreco() {
			return preco;
		}



		public void setPreco(BigDecimal preco) {
			this.preco = preco;
		}



		public String getDimensao() {
			return dimensao;
		}



		public void setDimensao(String dimensao) {
			this.dimensao = dimensao;
		}



		public String getMaterial() {
			return material;
		}



		public void setMaterial(String material) {
			this.material = material;
		}



		public BigDecimal getPeso() {
			return peso;
		}



		public void setPeso(BigDecimal peso) {
			this.peso = peso;
		}



		public String getConteudoProduto() {
			return conteudoProduto;
		}



		public void setConteudoProduto(String conteudoProduto) {
			this.conteudoProduto = conteudoProduto;
		}



		public String getImgProduto() {
			return imgProduto;
		}



		public void setImgProduto(String imgProduto) {
			this.imgProduto = imgProduto;
		}



		public String getMarca() {
			return marca;
		}



		public void setMarca(String marca) {
			this.marca = marca;
		}



		public String getFornecedor() {
			return fornecedor;
		}



		public void setFornecedor(String fornecedor) {
			this.fornecedor = fornecedor;
		}



		public String getCategoria() {
			return categoria;
		}



		public void setCategoria(String categoria) {
			this.categoria = categoria;
		}



		public static List<ItemPedidoDTO> converter(List<ItemPedido> itemPedidos) {
			return itemPedidos.stream().map(ItemPedidoDTO::new).collect(Collectors.toList());
		}
		 
		
		
}
