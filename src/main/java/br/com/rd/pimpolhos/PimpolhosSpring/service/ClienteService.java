package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
//import br.com.rd.pimpolhos.PimpolhosSpring.model.TipoTelefone;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
//import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EstadoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.TelefoneRepository;
//import br.com.rd.pimpolhos.PimpolhosSpring.repository.TipoTelefoneRepository;
//import br.com.rd.pimpolhos.PimpolhosSpring.repository.TipoTelefoneRepository;


@Service
public class ClienteService {
	
	@Autowired
	private final ClienteRepository clienteRepository;
	private final TelefoneRepository telefoneRepository;
	private final EnderecoRepository enderecoRepository;
	//private final EnderecoClienteRepository enderecoClienteRepository;
	private final EstadoRepository estadoRepository;
	//private final TipoTelefoneRepository tipoTelefoneRepository;
	private Boolean sistema = true;
	
	PasswordEncoder passwordEncoder;

	public ClienteService(ClienteRepository clienteRepository, TelefoneRepository telefoneRepository, EnderecoRepository enderecoRepository, EstadoRepository estadoRepository , PasswordEncoder passwordEncoder) {
		this.clienteRepository = clienteRepository;
		this.telefoneRepository = telefoneRepository;
		this.enderecoRepository = enderecoRepository;
		//this.enderecoClienteRepository = enderecoClienteRepository;
		this.estadoRepository = estadoRepository;
		this.passwordEncoder = passwordEncoder;
		//this.tipoTelefoneRepository = tipoTelefoneRepository;
	}

	

	public void deletar(Integer id) {
		clienteRepository.deleteById(id);
	}

	
	public Iterable<Cliente> visualizar() {
		return clienteRepository.findAll();
	}
	
	
	public Optional<Cliente> visualizarPorId(Integer id) {
		return clienteRepository.findById(id);
		
	}

	
	@Transactional
	public Cliente atualizar(Integer id, Cliente clienteAtualizado) {
		Cliente cliente = clienteRepository.findById(id).get();
		
		cliente.setNomeCliente(clienteAtualizado.getNomeCliente());
		cliente.setSenha(clienteAtualizado.getSenha());
		
		return clienteRepository.save(cliente);
	}
	
	
	public void salvar(Cliente cliente) {
		cliente.setSenha(this.passwordEncoder.encode(cliente.getSenha()));
		cliente.setCpf(cliente.getCpf().replace(".", "").replace("-", ""));

		clienteRepository.save(cliente);
	}
	
}
