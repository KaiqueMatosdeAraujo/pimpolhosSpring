package br.com.rd.pimpolhos.PimpolhosSpring.form;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.PedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Frete;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.StatusPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
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
	
	
	private List<ItemPedido> itemPedido;
	

	


	public PedidoForm(Date dataPedido, String cliente, String frete,String pagamento, String statusPedido ) throws ParseException {
		this.dataPedido = dataPedido;
		this.cliente = Integer.parseInt(cliente);
		this.frete = Integer.parseInt(frete);
		this.statusPedido = Integer.parseInt(statusPedido);
		this.pagamento = Integer.parseInt(pagamento);
	}


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


	
	
	
	public Pedido converter(ClienteRepository clienteRepository ,FreteRepository freteRepository , StatusPedidoRepository statusPedidoRepository , PagamentoRepository pagamentoRepository) throws ParseException {
		Optional<Cliente>cliente = clienteRepository.findById(this.cliente);
		Optional<Frete>frete = freteRepository.findById(this.frete);
		Optional<StatusPedido>statusPedido = statusPedidoRepository.findById(this.statusPedido);
		Optional<Pagamento>pagamento = pagamentoRepository.findById(this.pagamento);
		
		Pedido pedido = new Pedido(dataPedido , cliente.get() ,  frete.get() ,pagamento.get(), statusPedido.get() );
		return pedido;
	}
	
	public List<PedidoDTO> cadastrar (Pedido pedido , Cliente cliente , PedidoRepository pedidoRepository){
		List<Pedido>pedidos;
		pedidos = cliente.getPedidos();
		pedidos.add(pedido);
		cliente.setPedidos(pedidos);
		return PedidoDTO.converter(pedidos);
		
	}
	
	
}
