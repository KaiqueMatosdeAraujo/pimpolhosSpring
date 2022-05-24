package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.EnderecoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.dto.ItemPedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.form.EnderecoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.form.ItemPedidoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Estado;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedidoID;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EstadoRepository;

@Service
public class EnderecoService {

	@Autowired
	private final EnderecoRepository enderecoRepository;
	@Autowired
	private final EstadoRepository estadoRepository;
	@Autowired
	private final ClienteRepository clienteRepository;

	public  EnderecoService( EnderecoRepository  enderecoRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository) {
		this.enderecoRepository = enderecoRepository;
		this.estadoRepository = estadoRepository;
		this.clienteRepository = clienteRepository;
	}
	
	
	private void deletar(Integer id) {
		enderecoRepository.deleteById(id);
	}
	
	private Iterable<Endereco> visualizar() {
		 return enderecoRepository.findAll();
	}
	
	private void atualizar(Scanner sc) {
		System.out.println("Informe o Id do Endereco a ser atualizado");
		Integer codEndereco = sc.nextInt();
		
		Endereco endereco = enderecoRepository.findById(codEndereco).get();
		
		
		System.out.println("Informe o novo nome da Cidade");
		String nomeCidade = sc.next();
		System.out.println("Informe o novo cep ");
		String cep = sc.next();
		System.out.println("Informe o novo nome da rua");
		String nomeRua = sc.next();	
		System.out.println("Informe o novo numero da casa");
		String numeroCasa = sc.next();
		System.out.println("Informe o novo complemento");
		String complemento = sc.next();
		System.out.println("Informe o novo bairro");
		String bairro = sc.next();
		System.out.println("Informe o novo Ponto de referencia");
		String pontoReferencia = sc.next();
		
		
	System.out.println("Informe o novo codigo do estado");
		Integer codEstado = sc.nextInt();
		
		Optional<Estado> estado = estadoRepository.findById(codEstado);
		Optional<Endereco> enderecos = enderecoRepository.findById(codEndereco);
		
		endereco.setNomeCidade(nomeCidade);
		endereco.setCep(cep);
		endereco.setNomeRua(nomeRua);
		endereco.setNumeroCasa(numeroCasa);
		endereco.setComplemento(complemento);
		endereco.setBairro(bairro);
		endereco.setPontoReferencia(pontoReferencia);
		endereco.setEstado(estado.get());
		
		enderecoRepository.save(endereco);
		
		
//		System.out.println("deseja alterar o estado do endereco [s/n] ? ");
//		String resposta = sc.next();
//		if (resposta.equals("s")) {
//			List<Estado> estados = endereco.getEstado();
//			estados.forEach(estado -> System.out.println(estado));
//			System.out.println("informe o Id do Estado que deseja alterar:");
//			Integer estadoId = Integer.parseInt(sc.next());
//			
//			Optional<Estado> estado = estadoRepository.findById(estadoId);
//			//estados.add(atualizarEstado(sc, estado.get()));
//			endereco.setEstado(estados);
//		}
//		enderecoRepository.save(endereco);
		System.out.println("Endereco Atualizado com Sucesso");

	}

	public Endereco salvar(Endereco endereco, Integer codCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(codCliente);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = cliente.get().getEndereco();
		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public EnderecoDTO insert(EnderecoForm enderecoForm) {
		Endereco endereco = new Endereco();
		endereco.setNomeCidade(enderecoForm.getNomeCidade());
		endereco.setCep(enderecoForm.getCep());
		endereco.setNomeRua(enderecoForm.getNomeRua());
		endereco.setNumeroCasa(enderecoForm.getNumeroCasa());
		endereco.setComplemento(enderecoForm.getComplemento());
		endereco.setBairro(enderecoForm.getBairro());
		endereco.setPontoReferencia(enderecoForm.getPontoReferencia());
		//endereco.setCliente(Integer.parseInt(enderecoForm.getCodCliente()));
		endereco = enderecoRepository.save(endereco);
		return new EnderecoDTO(endereco);
	}
	
}
