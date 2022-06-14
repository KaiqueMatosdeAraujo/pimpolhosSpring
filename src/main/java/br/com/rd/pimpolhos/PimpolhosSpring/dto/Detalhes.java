package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;

public class Detalhes {
	private Integer codPedido;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	private Date dataPedido;
	private String descricaoFrete;
	private BigDecimal valorFrete;
	
	private String descricaoStatus;
	
	private List<Endereco> clienteEndereco;
	
	private String clienteNome;
//	private List<ItemPedido> itemPedido;
	private String formaPagamento;
	
	private BigDecimal total;


	public Detalhes(Pedido pedido) {
		this.clienteEndereco = pedido.getCliente().getEndereco();
		this.clienteNome = pedido.getCliente().getNomeCliente();
		this.codPedido = pedido.getCodPedido();
//		this.dataPedido = pedido.getDataPedido();
		this.descricaoFrete = pedido.getFrete().getDescricaoFrete();
		this.valorFrete = pedido.getFrete().getValorFrete();
		this.descricaoStatus = pedido.getStatusPedido().getDescricaoStatusPedido();
		this.formaPagamento = pedido.getPagamento().getFormaPagamento().getDescricao();
		this.total = total;
	}


	public Integer getCodPedido() {
		return codPedido;
	}


	public void setCodPedido(Integer codPedido) {
		this.codPedido = codPedido;
	}


	public String getDataPedido() {
		String data = formato.format(dataPedido);
		return data;
	}


	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}


	public String getDescricaoFrete() {
		return descricaoFrete;
	}


	public void setDescricaoFrete(String descricaoFrete) {
		this.descricaoFrete = descricaoFrete;
	}


	public BigDecimal getValorFrete() {
		return valorFrete;
	}


	public void setValorFrete(BigDecimal valorFrete) {
		this.valorFrete = valorFrete;
	}


	public String getDescricaoStatus() {
		return descricaoStatus;
	}


	public void setDescricaoStatus(String descricaoStatus) {
		this.descricaoStatus = descricaoStatus;
	}


//	public List<ItemPedido> getItemPedido() {
////		List<ItemPedido> nova = ItemPedidoDTO.converter(itemPedido);  nova no return
//		return itemPedido;
//	}
//
//
//	public void setItemPedido(List<ItemPedido> itemPedido) {
//		this.itemPedido = itemPedido;
//	}
//

	public String getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	public BigDecimal getTotal() {
		return total;
	}


	public void setTotal(BigDecimal total) {
		this.total = total;
	}


	public List<Endereco> getClienteEndereco() {
		return clienteEndereco;
	}


	public void setClienteEndereco(List<Endereco> clienteEndereco) {
		this.clienteEndereco = clienteEndereco;
	}


	public String getClienteNome() {
		return clienteNome;
	}


	public void setClienteNome(String clienteNome) {
		this.clienteNome = clienteNome;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codPedido);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Detalhes other = (Detalhes) obj;
		return Objects.equals(codPedido, other.codPedido);
	}
	
//	public  BigDecimal totalPedido(List<ItemPedido> valor) {
//		List<ItemPedidoDTO> nova = ItemPedidoDTO.converter(valor);
//		BigDecimal soma = nova.stream().map(produto -> produto.getPreco()).reduce(BigDecimal.ZERO, BigDecimal::add);	
//		return soma;
//	}

	public static List<Detalhes> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(Detalhes::new).collect(Collectors.toList());
	}

	
	
}
