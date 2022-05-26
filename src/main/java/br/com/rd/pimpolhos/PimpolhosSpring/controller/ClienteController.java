package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.ClienteDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.dto.DetalhePedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Telefone;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.TelefoneRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.service.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private TelefoneRepository telefoneRepository;
	
	@GetMapping
	public Iterable<Cliente> listar() {

		Iterable<Cliente> clientes = clienteService.visualizar();

		return clientes;
	}
	
	//RETORNA TELEFONE POR CLIENTE
//	@GetMapping("/{id}/telefone")
//	public ResponseEntity<TelefoneDTO> listar(@PathVariable("id") Integer id ,  Integer idtelefone) {
//		Optional<Telefone> telefone = telefoneRepository.findById(idtelefone);
//		Optional<Cliente> cliente = clienteRepository.findById(id);
//		List<Telefone>telefones = new ArrayList<>();
//		telefones = cliente.get().getTelefone();
//		
//		if (cliente.isPresent() && telefones.contains(telefone.get())) {
//			return ResponseEntity.ok().body(new TelefoneDTO(telefone.get()));
//		}
//		
//		return ResponseEntity.notFound().build(); 
//	}
	
	
	//RETORNA O CLIENTE DTO
	@GetMapping("listar")
	public List<ClienteDTO> listarClientes(){
		List<Cliente> cliente = clienteRepository.findAll();
		return ClienteDTO.converter(cliente);
	}
	
	
	@GetMapping("/{id}")
	public Optional<Cliente> buscarPorId(@PathVariable("id") Integer id){
		return clienteService.visualizarPorId(id);
	}
	
	
	@PostMapping("/cadastrar")
	@Transactional
	public ResponseEntity<Cliente> cadastrar(@RequestBody @Valid Cliente cliente, Endereco endereco, UriComponentsBuilder uriBuilder) {
		clienteService.salvar(cliente);
		URI uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getCodCliente()).toUri();
		return ResponseEntity.created(uri).body(cliente);
	}
	
	@PutMapping("/{id}")
	@Transactional
	public Cliente atualizar(@RequestBody Cliente cliente, Endereco endereco, @PathVariable("id") Integer id){
		return clienteService.atualizar(id, cliente);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void deletar (@PathVariable("id") Integer id){
		clienteService.deletar(id);
		
	}
}
