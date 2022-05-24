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

import br.com.rd.pimpolhos.PimpolhosSpring.dto.NotaFiscalDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.NotaFiscal;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.NotaFiscalRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.service.NotaFiscalService;

@RestController
@RequestMapping("/notaFiscal")
public class NotaFiscalController {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	@Autowired
	private NotaFiscalService notaFiscalRService;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@GetMapping
	public List<NotaFiscal> listar() {
		List<NotaFiscal> notaFiscal = notaFiscalRepository.findAll();
		return notaFiscal;
	}
	
	@GetMapping("listar") 
	public List<NotaFiscalDTO> listarNotaFiscal() { 
		List<NotaFiscal> notaFiscal = notaFiscalRepository.findAll(); 
		return NotaFiscalDTO.converter(notaFiscal); 
	} 
	
	
//	@GetMapping("/{idpedido}/{idnota}")
//	public ResponseEntity<NotaFiscal> listar(@PathVariable("idpedido") Integer idpedido, @PathVariable("idnota") Integer idnota){
//		Optional<NotaFiscal> notaFiscal = notaFiscalRepository.findById(idnota);
//		Optional<Pedido> pedido = pedidoRepository.findById(idpedido);
//		List<NotaFiscal> notas = new ArrayList<>();
//		notas = pedido.get().
//		
//		if (pedido.isPresent() && notas.contains(notaFiscal.get())) {
//			return ResponseEntity.ok().body(new NotaFiscal());
//		}
//		
//		return ResponseEntity.notFound().build(); 
//	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<NotaFiscal> cadastrar(@RequestBody @Valid NotaFiscal notaFiscal, UriComponentsBuilder uriBuilder){
		notaFiscalRService.salvar(notaFiscal);
		URI uri = uriBuilder.path("/notaFiscal/{id}").buildAndExpand(notaFiscal.getCodNf()).toUri();
		return ResponseEntity.created(uri).body(notaFiscal);
		
	}
	
}
