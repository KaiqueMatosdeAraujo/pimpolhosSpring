package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.Detalhes;
import br.com.rd.pimpolhos.PimpolhosSpring.dto.PedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.form.PedidoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.FreteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.StatusPedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private FreteRepository freteRepository;
	@Autowired
	private StatusPedidoRepository statusPedidoRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	
	
//	@GetMapping
//	public Iterable<Pedido> listar() {
//		Iterable<Pedido> pagamentos = pedidoService.visualizar();
//		return pagamentos;
//	}
	
	@GetMapping
	public List<Detalhes> listar() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return Detalhes.converter(pedidos);
	}

	@PostMapping("/cl={id}/cadastrar")
	@Transactional
	public ResponseEntity<PedidoDTO> cadastrar(@PathVariable("id") Integer id , @RequestBody @Valid PedidoForm pedidoForm , 
												UriComponentsBuilder uriBuilder){
		Optional<Cliente> cliente = clienteRepository.findById(id);
		Pedido pedido = pedidoForm.converter(clienteRepository , freteRepository, statusPedidoRepository, pagamentoRepository);
		pedidoRepository.save(pedido);
		pedidoForm.cadastrar(pedido, cliente.get() , pedidoRepository);
		
		URI uri = uriBuilder.path("/pedido/{id}").buildAndExpand(pedido.getCodPedido()).toUri();
		return ResponseEntity.created(uri).body(new PedidoDTO(pedido));
		
	}
	
	@GetMapping("/cl={id}/detalhar/{idpedido}")
	public ResponseEntity<PedidoDTO> detalharPedido(@PathVariable("id") Integer id ,@PathVariable("idpedido")  Integer idpedido){
		Optional<Pedido> testePedido = pedidoRepository.findById(id);
		Optional<Cliente> cliente = clienteRepository.findById(id);
		List<Pedido>pedidos = new ArrayList<>();
		pedidos = cliente.get().getPedidos();
		if (cliente.isPresent() && pedidos.contains(testePedido.get())) {

			return ResponseEntity.ok().body(new PedidoDTO(testePedido.get()));
			}
			return ResponseEntity.notFound().build(); 
	}
	
	@GetMapping("/cl={id}/detalhe/{idpedido}")
	public ResponseEntity<Detalhes> detalhar(@PathVariable("id") Integer id ,@PathVariable("idpedido")  Integer idpedido){
		Optional<Pedido> testePedido = pedidoRepository.findById(id);
		Optional<Cliente> cliente = clienteRepository.findById(id);
		List<Pedido>pedidos = new ArrayList<>();
		pedidos = cliente.get().getPedidos();
		if (cliente.isPresent() && pedidos.contains(testePedido.get())) {

			return ResponseEntity.ok().body(new Detalhes(testePedido.get()));
			}
			return ResponseEntity.notFound().build(); 
	}
	
	
	

	
	
}