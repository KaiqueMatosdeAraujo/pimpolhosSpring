package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.CartaoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.CartaoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

	@Autowired
	private CartaoRepository cartaoRepository;
	private ClienteRepository clienteRepository;
	
	@GetMapping
	public List<CartaoDTO> listar(){
		List<Cartao> cartao = cartaoRepository.findAll();
		return CartaoDTO.converter(cartao);
	}
	
	//ID CARTÃO ESTÁ VOLTANDO NULO
//	@GetMapping("/{idcliente}/{idcartao}")
//	public ResponseEntity<CartaoDTO> listar(@PathVariable("idcliente") Integer idcliente, @PathVariable("idcartao") Integer idcartao){
//		Optional<Cartao> cartao = cartaoRepository.findById(idcartao);
//		Optional<Cliente> cliente = clienteRepository.findById(idcliente);
//		List<Cartao> cartoes = new ArrayList<>();
//		cartoes = cliente.get().getCartoes();
//		
//		if(cliente.isPresent() && cartoes.contains(cartao.get())) {
//			return ResponseEntity.ok().body(new CartaoDTO(cartao.get()));
//		}
//		
//		return ResponseEntity.notFound().build(); 
//	}
	
	
}
