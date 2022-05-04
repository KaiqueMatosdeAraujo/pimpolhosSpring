package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.service.PagamentoService;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

	private PagamentoRepository pagamentoRepository;
	private PagamentoService pagamentoService;
	
	@GetMapping
	public Iterable<Pagamento> listar() {
		Iterable<Pagamento> pagamentos = pagamentoService.visualizar();
		return pagamentos;
	}
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Pagamento> cadastrar(@RequestBody @Valid Pagamento pagamento, UriComponentsBuilder uriBuilder){
		pagamentoService.salvar(pagamento);
		URI uri = uriBuilder.path("/pagamento/{id}").buildAndExpand(pagamento.getCodPagamento()).toUri();
		return ResponseEntity.created(uri).body(pagamento);
		
	}
}
