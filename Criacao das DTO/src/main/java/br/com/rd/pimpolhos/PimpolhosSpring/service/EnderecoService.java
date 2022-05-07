package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Estado;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EstadoRepository;

@Service
public class EnderecoService {

	@Autowired
	private final EnderecoRepository enderecoRepository;
	private final EstadoRepository estadoRepository;
	private Boolean sistema = true;

	public  EnderecoService( EnderecoRepository  enderecoRepository, EstadoRepository estadoRepository) {
		this.enderecoRepository = enderecoRepository;
		this.estadoRepository = estadoRepository;
	
	}
	
	
	public void iniciar(Scanner sc) {
		int acao;
	

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Endereco");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			acao = sc.nextInt();

			switch (acao) {
			case 1:
				salvar(sc);
				break;
			case 2:
				atualizar(sc);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(sc);
				break;
			default:
				sistema = false;
				break;	
			}
		}
	}
	
	
	private void deletar(Scanner sc) {
		int id;
		System.out.println("Informe o ID do endereco a ser deletado");
		
		id = sc.nextInt();
		
		enderecoRepository.deleteById(id);
		
		System.out.println("Endereco deletado com sucesso");
	}
	
	private void visualizar() {
		Iterable<Endereco> enderecos = enderecoRepository.findAll();
		enderecos.forEach(endereco -> System.out.println(endereco));
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

	private void salvar(Scanner sc) {
		System.out.println("Informe o nome da Cidade");
		String nomeCidade = sc.next();
		System.out.println("Informe o cep ");
		String cep = sc.next();
		System.out.println("Informe o nome da rua");
		String nomeRua = sc.next();	
		System.out.println("Informe o numero da casa");
		String numeroCasa = sc.next();
		System.out.println("Informe o complemento");
		String complemento = sc.next();
		System.out.println("Informe o bairro");
		String bairro = sc.next();
		System.out.println("Informe o Ponto de referencia");
		String pontoReferencia = sc.next();
		System.out.println("Informe o codigo do estado");
		Integer codEstado = sc.nextInt();
		
		Optional<Estado> optional = estadoRepository.findById(codEstado);
		if(optional.isPresent()) {
			Estado estado = optional.get();
			Endereco endereco = new Endereco(nomeCidade, cep, nomeRua, numeroCasa, complemento, bairro, pontoReferencia, estado);
			enderecoRepository.save(endereco);
			System.out.println("Endereco Cadastrado");
		}else {
		
		

		System.out.println("Erro ao Cadastrar");
		}
	}
}
