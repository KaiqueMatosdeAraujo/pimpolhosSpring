package br.com.rd.pimpolhos.PimpolhosSpring.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
	
	
	private String dataPedido;
//	private SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
	
	

	private String cliente;
 
	private String frete; 
	
	private String pagamento;
	
	private String statusPedido; 
	
	private String endereco;
	
//	private List<ItemPedido> itemPedido;
	

//	public PedidoForm(LocalDate dataPedido,String frete , String statusPedido ,String pagamento,String cliente , String endereco) throws ParseException {
//		this.dataPedido = dataPedido;
//		this.frete = Integer.parseInt(frete);
//		this.statusPedido = Integer.parseInt(statusPedido);
//		this.pagamento = Integer.parseInt(pagamento);
//		this.cliente = Integer.parseInt(cliente);
//		this.endereco = Integer.parseInt(endereco);
//	}


//	public PedidoForm(Date dataPedido, String cliente, String frete,String pagamento, String statusPedido ) throws ParseException {
//		this.dataPedido = dataPedido;
//		this.cliente = Integer.parseInt(cliente);
//		this.frete = Integer.parseInt(frete);
//		this.statusPedido = Integer.parseInt(statusPedido);
//		this.pagamento = Integer.parseInt(pagamento);
//	}


	

//	public List<ItemPedido> getItemPedido() {
//		return itemPedido;
//	}
//
//
//	public void setItemPedido(List<ItemPedido> itemPedido) {
//		this.itemPedido = itemPedido;
//	}


	public String getDataPedido() {
		return dataPedido;
	}


	public void setDataPedido(String dataPedido) {
		this.dataPedido = dataPedido;
	}


	public String getCliente() {
		return cliente;
	}


	public void setCliente(String cliente) {
		this.cliente = cliente;
	}


	public String getFrete() {
		return frete;
	}


	public void setFrete(String frete) {
		this.frete = frete;
	}


	public String getPagamento() {
		return pagamento;
	}


	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}


	public String getStatusPedido() {
		return statusPedido;
	}


	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	
	
	
//	public Pedido converter(ClienteRepository clienteRepository ,FreteRepository freteRepository , StatusPedidoRepository statusPedidoRepository , PagamentoRepository pagamentoRepository , EnderecoRepository enderecoRepository) throws ParseException {
//		Optional<Cliente>cliente = clienteRepository.findById(this.cliente);
//		Optional<Frete>frete = freteRepository.findById(this.frete);
//		Optional<StatusPedido>statusPedido = statusPedidoRepository.findById(this.statusPedido);
//		Optional<Pagamento>pagamento = pagamentoRepository.findById(this.pagamento);
//		Optional<Endereco>endereço = enderecoRepository.findById(this.endereco);
//		
//		Pedido pedido = new Pedido(dataPedido ,cliente.get(),frete.get(),pagamento.get(),statusPedido.get());
//		return pedido;
//	}
//	
//	public List<PedidoDTO> cadastrar (Pedido pedido , Cliente cliente , PedidoRepository pedidoRepository ){
//		List<Pedido>pedidos;
//		pedidos = cliente.getPedidos();
//		pedidos.add(pedido);
//		cliente.setPedidos(pedidos);
//		return PedidoDTO.converter(pedidos);
//		
//	}
	
	
}
