package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.PedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.form.PedidoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Frete;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.StatusPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.FreteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ItemPedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.StatusPedidoRepository;

@Service
public class PedidoService {
	
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	FreteRepository freteRepository;
	@Autowired
	PagamentoRepository pagamentoRepository;
	@Autowired
	StatusPedidoRepository statusPedidoRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	private final PedidoRepository pedidoRepository;
	private final ItemPedidoRepository itemPedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository, ItemPedidoRepository itemPedidoRepository) {
		this.pedidoRepository = pedidoRepository;
		this.itemPedidoRepository = itemPedidoRepository;
	}
	
	
	public Iterable<Pedido> visualizar(){
		return pedidoRepository.findAll();
	}
	
	public void salvar(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

	public PedidoDTO cadastrar (PedidoForm form) {
		Pedido pedido = new Pedido();
		pedido.setDataPedido(LocalDate.parse(form.getDataPedido() , formatter));
		Optional<Cliente> cliente = clienteRepository.findById(Integer.parseInt(form.getCliente()));
		Optional<Frete> frete = freteRepository.findById(Integer.parseInt(form.getFrete()));
		Optional<Pagamento> pagamento = pagamentoRepository.findById(Integer.parseInt(form.getPagamento()));
		Optional<StatusPedido> statusPedido = statusPedidoRepository.findById(Integer.parseInt(form.getStatusPedido()));
		Optional<Endereco> endereco = enderecoRepository.findById(Integer.parseInt(form.getEndereco()));
		if(cliente.isPresent() && frete.isPresent() && pagamento.isPresent() && statusPedido.isPresent() && endereco.isPresent()) {
			pedido.setCliente(cliente.get());
			pedido.setFrete(frete.get());
			pedido.setPagamento(pagamento.get());
			pedido.setStatusPedido(statusPedido.get());
			pedido.setEndereco(endereco.get());
			pedido = pedidoRepository.save(pedido);
		}else {
			cliente.orElseThrow();
			frete.orElseThrow();
			pagamento.orElseThrow();
			statusPedido.orElseThrow();
			endereco.orElseThrow();
		}
		return new PedidoDTO(pedido);
	}
}