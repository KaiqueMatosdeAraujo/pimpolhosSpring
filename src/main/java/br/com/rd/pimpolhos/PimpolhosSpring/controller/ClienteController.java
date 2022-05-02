package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.service.ClienteService;
import br.com.rd.pimpolhos.PimpolhosSpring.service.EnderecoService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping
	public Iterable<Cliente> Listar() {

		Iterable<Cliente> clientes = clienteService.visualizar();

		return clientes;
	}
	
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente, Endereco endereco, UriComponentsBuilder uriBuilder) {
		clienteService.salvar(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getCodCliente()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar (@PathVariable("id") Integer id){
		clienteService.deletar(id);
		
	}
}
