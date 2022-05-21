package br.com.rd.pimpolhos.PimpolhosSpring.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.PedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Frete;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.StatusPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.FreteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.StatusPedidoRepository;

public class PedidoForm {
	
	
	private Date dataPedido;
	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	

	private Integer cliente;
 
	private Integer frete; 
	
	private Integer pagamento;
	
	private Integer statusPedido; 
	
	private Integer endereco;
	
	private List<ItemPedido> itemPedido;
	

	public PedidoForm(Date dataPedido,String frete , String statusPedido ,String pagamento,String cliente , String endereco) throws ParseException {
		this.dataPedido = dataPedido;
		this.frete = Integer.parseInt(frete);
		this.statusPedido = Integer.parseInt(statusPedido);
		this.pagamento = Integer.parseInt(pagamento);
		this.cliente = Integer.parseInt(cliente);
		this.endereco = Integer.parseInt(endereco);
	}


//	public PedidoForm(Date dataPedido, String cliente, String frete,String pagamento, String statusPedido ) throws ParseException {
//		this.dataPedido = dataPedido;
//		this.cliente = Integer.parseInt(cliente);
//		this.frete = Integer.parseInt(frete);
//		this.statusPedido = Integer.parseInt(statusPedido);
//		this.pagamento = Integer.parseInt(pagamento);
//	}


	public Date getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	


	public Integer getFrete() {
		return frete;
	}


	public void setFrete(Integer frete) {
		this.frete = frete;
	}


	public Integer getStatusPedido() {
		return statusPedido;
	}


	public void setStatusPedido(Integer statusPedido) {
		this.statusPedido = statusPedido;
	}


	public Integer getPagamento() {
		return pagamento;
	}


	public void setPagamento(Integer pagamento) {
		this.pagamento = pagamento;
	}


	public List<ItemPedido> getItemPedido() {
		return itemPedido;
	}


	public void setItemPedido(List<ItemPedido> itemPedido) {
		this.itemPedido = itemPedido;
	}


	
	
	
	public Pedido converter(ClienteRepository clienteRepository ,FreteRepository freteRepository , StatusPedidoRepository statusPedidoRepository , PagamentoRepository pagamentoRepository , EnderecoRepository enderecoRepository) throws ParseException {
		Optional<Cliente>cliente = clienteRepository.findById(this.cliente);
		Optional<Frete>frete = freteRepository.findById(this.frete);
		Optional<StatusPedido>statusPedido = statusPedidoRepository.findById(this.statusPedido);
		Optional<Pagamento>pagamento = pagamentoRepository.findById(this.pagamento);
		Optional<Endereco>endereço = enderecoRepository.findById(this.endereco);
		
		Pedido pedido = new Pedido(dataPedido , frete.get() ,statusPedido.get() ,pagamento.get() ,cliente.get(), endereço.get());
		return pedido;
	}
	
	public List<PedidoDTO> cadastrar (Pedido pedido , Cliente cliente , PedidoRepository pedidoRepository ){
		List<Pedido>pedidos;
		pedidos = cliente.getPedidos();
		pedidos.add(pedido);
		cliente.setPedidos(pedidos);
		return PedidoDTO.converter(pedidos);
		
	}
	
	
}
