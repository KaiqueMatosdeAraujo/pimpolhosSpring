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

import br.com.rd.pimpolhos.PimpolhosSpring.form.CartaoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.dto.CartaoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.BandeiraRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.CartaoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoRepository cartaoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private BandeiraRepository bandeiraRepository;
	
	@GetMapping
	public List<CartaoDTO> listar(){
		List<Cartao> cartao = cartaoRepository.findAll();
		return CartaoDTO.converter(cartao);
	}
	
	//LISTA TODOS OS CARTÕES DE UM CLIENTE
	@GetMapping("/{idcliente}")
	public List<CartaoDTO> listar(@PathVariable("idcliente") Integer idcliente){
		List<Cartao> cartao = cartaoRepository.findByClienteCodCliente(idcliente);
		CartaoDTO cartaoDTO = new CartaoDTO();
		return cartaoDTO.converter(cartao);
	}
	
//	CADASTRAR CARTÃO ASSOCIANDO A UM CLIENTE
	@PostMapping("{codCliente}/cadastrar")
	public ResponseEntity<CartaoDTO> cadastrar(@PathVariable("codCliente") Integer codCliente , @RequestBody @Valid CartaoForm cartaoForm , 
			UriComponentsBuilder uriBuilder){
		Optional<Cliente> cliente = clienteRepository.findById(codCliente);
		Cartao cartao = cartaoForm.converter(bandeiraRepository, clienteRepository);
		cartaoRepository.save(cartao);
		cartaoForm.cadastrar(cartao, cliente.get() , clienteRepository);
		
		URI uri = uriBuilder.path("/cadastrar/{codCliente}").buildAndExpand(cartao.getCodCartao()).toUri();
		return ResponseEntity.created(uri).body(new CartaoDTO(cartao));
	}
}