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

import br.com.rd.pimpolhos.PimpolhosSpring.dto.EnderecoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoRepository;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository enderecoRepository;
	private ClienteRepository clienteRepository;
	
	
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
	
}
