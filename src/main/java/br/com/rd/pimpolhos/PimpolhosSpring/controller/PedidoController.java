package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.service.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

	private PedidoRepository pedidoRepository;
	@Autowired
	private PedidoService pedidoService;
	
	@GetMapping
	public Iterable<Pedido> listar() {
		Iterable<Pedido> pagamentos = pedidoService.visualizar();
		return pagamentos;
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Pedido> cadastrar(@RequestBody @Valid Pedido pedido, UriComponentsBuilder uriBuilder){
		pedidoService.salvar(pedido);
		URI uri = uriBuilder.path("/pagamento/{id}").buildAndExpand(pedido.getCodPedido()).toUri();
		return ResponseEntity.created(uri).body(pedido);
		
	}
	
	
}