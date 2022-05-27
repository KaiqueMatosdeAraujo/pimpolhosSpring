package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.EnderecoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.form.EnderecoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EstadoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoService enderecoService;
	@Autowired
	private EstadoRepository estadoRepository;
	
	//LISTA UM ENDEREÇOS DE UM CLIENTE
	@GetMapping("/{idcliente}/{idendereco}")
	public ResponseEntity<EnderecoDTO> listar(@PathVariable("idcliente") Integer idcliente, @PathVariable("idendereco") Integer idendereco){
		Optional<Endereco> endereco = enderecoRepository.findById(idendereco);
		Optional<Cliente> cliente = clienteRepository.findById(idcliente);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = cliente.get().getEndereco();
		
		if(cliente.isPresent() && enderecos.contains(endereco.get())) {
			return ResponseEntity.ok().body(new EnderecoDTO(endereco.get()));
		}
		
		return ResponseEntity.notFound().build(); 
	}
	
	//LISTA TODOS OS ENDEREÇOS DE UM CLIENTE
	@GetMapping("/{idcliente}")
	public List<EnderecoDTO> listar(@PathVariable("idcliente") Integer idcliente){
		List<Endereco> endereco = enderecoRepository.findByClienteCodCliente(idcliente);
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		return enderecoDTO.converter(endereco);
	}
	
//	@PostMapping("/cadastrar")
//	@Transactional
//	public ResponseEntity<EnderecoDTO> cadastrar(@RequestBody EnderecoForm enderecoForm){
//		try {
//			EnderecoDTO endereco = enderecoService.insert(enderecoForm);
//			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getc.toUri();
//		        
//		    return ResponseEntity.created(uri).body(endereco);
//		} catch (ServiceException e) {
//		     return ResponseEntity.unprocessableEntity().build();
//		}
//	}
	
//	@PostMapping("/{codCliente}/cadastrar")
//	@Transactional
//	public ResponseEntity<Endereco> cadastrar(@PathVariable("codCliente") Integer codCliente, @RequestBody @Valid Endereco endereco, UriComponentsBuilder uriComponentsBuilder){
//		enderecoService.salvar(endereco, codCliente);
//		URI uri = uriComponentsBuilder.path("/endereco/{id}").buildAndExpand(endereco.getCodEndereco()).toUri();
//		return ResponseEntity.created(uri).body(endereco);
//	}
	
	
	@PostMapping("/{codCliente}/cadastrar")
	public ResponseEntity<EnderecoDTO> cadastrar(@PathVariable("codCliente") Integer codCliente, @RequestBody @Valid EnderecoForm enderecoForm, UriComponentsBuilder uriBuilder){
		Optional<Cliente> cliente = clienteRepository.findById(codCliente);
		Endereco endereco = enderecoForm.converter(estadoRepository);
		enderecoRepository.save(endereco);
		enderecoForm.cadastrar(endereco, cliente.get(), clienteRepository);
		URI uri = uriBuilder.path("/cadastrar/{codCliente}").buildAndExpand(endereco.getCodEndereco()).toUri();
		return ResponseEntity.created(uri).body(new EnderecoDTO(endereco));
	}
	
	
	@RequestMapping(value = "/buscar", method = RequestMethod.DELETE)
	public void deletar (@RequestParam(value = "cod_endereco", defaultValue = "") Integer cod_endereco){
		enderecoService.deletar(cod_endereco);
		
	}
	
}