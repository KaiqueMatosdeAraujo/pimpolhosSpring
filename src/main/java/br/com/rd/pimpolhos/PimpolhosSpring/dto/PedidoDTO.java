package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.math.BigDecimal;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Telefone;

public class PedidoDTO {

	private Date dataPedido;
	private String descricaoFrete;
	private BigDecimal valorFrete;
	private String statusPedido;
	private List<ItemPedido> itemPedido;
	//private String descricaoFormaPagamento; 
	private Pagamento pagamento;
	//private Cliente cliente;
	private Endereco endereco;
//	private List<Telefone> telefone;
	private String nomeCliente;
	private String cpfCliente;
	private String numeroTelefoneCliente;
	private String dddCliente;
	private String nomeCidadeCliente;
	private String cepCliente;
	private String nomeRuaCliente;
	private String numeroCasaCliente;
	private String estadoCliente;
	
	public PedidoDTO(Pedido pedido) {
		this.dataPedido = pedido.getDataPedido();
		this.descricaoFrete = pedido.getFrete().getDescricaoFrete();
		this.valorFrete = pedido.getFrete().getValorFrete();
		this.statusPedido = pedido.getStatusPedido().getDescricaoStatusPedido();
		this.itemPedido = pedido.getItemPedido();
		//this.descricaoFormaPagamento = pedido.getPagamento().getFormaPagamento().getDescricao();
		this.itemPedido = pedido.getItemPedido();
		this.pagamento = pedido.getPagamento();
		this.nomeCliente = pedido.getCliente().getNomeCliente();
		this.cpfCliente = pedido.getCliente().getCpf();
		this.endereco = pedido.getEndereco();
//		this.telefone = pedido.getCliente().getTelefone();
//		this.numeroTelefoneCliente = pedido.getCliente().getTelefone().
//		this.dddCliente
//		this.nomeCidadeCliente = pedido.getCliente().getEndereco()
//		this.cepCliente
//		this.nomeRuaCliente
//		this.numeroCasaCliente
//		this.estadoCliente
	}

	public Date getDataPedido() {
		return dataPedido;
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

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
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
	

	

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	
	

	public static List<PedidoDTO> converter(List<Pedido> pedidos) {
		return pedidos.stream().map(PedidoDTO::new).collect(Collectors.toList());
	}
	
}
