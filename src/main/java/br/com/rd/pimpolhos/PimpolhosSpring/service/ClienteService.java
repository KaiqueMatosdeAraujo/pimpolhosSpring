package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Estado;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Telefone;
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
	
	public ClienteService(ClienteRepository clienteRepository, TelefoneRepository telefoneRepository, EnderecoRepository enderecoRepository, EstadoRepository estadoRepository) {
		this.clienteRepository = clienteRepository;
		this.telefoneRepository = telefoneRepository;
		this.enderecoRepository = enderecoRepository;
		//this.enderecoClienteRepository = enderecoClienteRepository;
		this.estadoRepository = estadoRepository;
		//this.tipoTelefoneRepository = tipoTelefoneRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Cliente");
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
		System.out.println("Informe o ID do Cliente a ser Deletado");
		
		id = sc.nextInt();
		
		clienteRepository.deleteById(id);
		
		System.out.println("Cliente deletado com sucesso");

	}

	private void visualizar() {
		Iterable<Cliente> clientes = clienteRepository.findAll();
		clientes.forEach(cliente-> System.out.println(cliente));
	}

	private void atualizar(Scanner sc) {
		System.out.println("Informe o Id do cliente a ser atualizado");
		Integer id = sc.nextInt();
		
		Cliente cliente = clienteRepository.findById(id).get();
		System.out.println("Informe o novo nome do Cliente");
		String nomeCliente = sc.next();
//		System.out.println("Informe o novo CPF do Cliente");
//		String cpf = sc.next();
//		System.out.println("Informe a nova data de nascimento do Cliente");
//		String data = sc.next();	
//		System.out.println("Informe o novo email do Cliente");
//		String email = sc.next();
		System.out.println("Informe a nova senha do Cliente");
		String senha = sc.next();
		
//		Telefone  telefone = telefoneRepository.findById(id).get();
//		System.out.println("Informe o novo telefone do Cliente");
//		String telefoneCliente = sc.next();
//		System.out.println("Informe o novo DDD do telefone do Cliente");
//		String dddTelefoneCliente = sc.next();
//		System.out.println("Informe o novo tipo de telefone [Celular/Telefone Fixo]");
//		String descricaoTelefone = sc.next();
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//LocalDate dataNasc = LocalDate.parse(data, formatter);

		
		
		cliente.setNomeCliente(nomeCliente);
		//cliente.setCpf(cpf);
		//cliente.setDataNasc(dataNasc);
		//cliente.setEmail(email);
		cliente.setSenha(senha);
//		telefone.setNumero_telefone(telefoneCliente);
//		telefone.setDdd(dddTelefoneCliente);
//		telefone.setDescricao_telefone(descricaoTelefone);
		clienteRepository.save(cliente); //NÃO É PRA SER NECESSÁRIO

		System.out.println("deseja alterar o telefone do cliente [s/n] ? ");
		String resposta = sc.next();
		if (resposta.equals("s")) {
			List<Telefone> telefones = cliente.getTelefone();
			telefones.forEach(telefone -> System.out.println(telefone));
			System.out.println("informe o Id do Telefone que deseja alterar:");
			Integer telefoneId = Integer.parseInt(sc.next());
			
			Optional<Telefone> tel = telefoneRepository.findById(telefoneId);
			telefones.add(atualizarTelefone(sc, tel.get()));
			cliente.setTelefone(telefones);
		}
		
		System.out.println("deseja alterar o telefone do cliente [s/n] ? ");
		String resposta2 = sc.next();
		if (resposta.equals("s")) {
			List<Endereco> enderecos = cliente.getEndereco();
			enderecos.forEach(endereco -> System.out.println(endereco));
			System.out.println("informe o Id do endereco que deseja alterar:");
			Integer enderecoId = Integer.parseInt(sc.next());
			
			Optional<Endereco> end = enderecoRepository.findById(enderecoId);
			enderecos.add(atualizarEndereco(sc, end.get()));
			cliente.setEndereco(enderecos);
		}
		
		
		clienteRepository.save(cliente);
		//telefoneRepository.save(telefone);
		
		System.out.println("Cliente Atualizado com Sucesso");

	}

	private void salvar(Scanner sc) {
		System.out.println("Informe o nome do Cliente");
		String nomeCliente = sc.next();
		System.out.println("Informe o CPF do Cliente");
		String cpf = sc.next();
		System.out.println("Informe a data de nascimento do Cliente");
		String data = sc.next();	
		System.out.println("Informe o email do Cliente");
		String email = sc.next();
		System.out.println("Informe a senha do Cliente");
		String senha = sc.next();
		
		
//		System.out.println("Informe o telefone do Cliente");
//		String telefoneCliente = sc.next();
//		System.out.println("Informe o DDD do telefone do Cliente");
//		String dddTelefoneCliente = sc.next();
//		System.out.println("Informe o tipo de telefone [Celular/Telefone Fixo]");
//		String descricaoTelefone = sc.next();
		//Integer codTelefoneCliente = Integer.parseInt(sc.next());
	//	Optional<TipoTelefone> tiposTelefone = tipoTelefoneRepository.findById(codTelefoneCliente);
 
//		System.out.println("Informe o nome da cidade do cliente:");
//		String nomeCidade = sc.next();
//		System.out.println("Informe o cep ");
//		String cep = sc.next();
//		System.out.println("Informe o nome da rua");
//		String nomeRua = sc.next();	
//		System.out.println("Informe o numero da casa");
//		String numeroCasa = sc.next();
//		System.out.println("Informe o complemento");
//		String complemento = sc.next();
//		System.out.println("Informe o bairro");
//		String bairro = sc.next();
//		System.out.println("Informe o Ponto de referencia");
//		String pontoReferencia = sc.next();
//		System.out.println("Informe o codigo do estado");
//		Integer codEstado = sc.nextInt();
//		
//		
//		Optional<Estado> optional = estadoRepository.findById(codEstado);
//		//if(optional.isPresent()) {
//			Estado estado = optional.get();
//			Endereco endereco = (new Endereco(nomeCidade, cep, nomeRua, numeroCasa, complemento, bairro, pontoReferencia, estado));
//			enderecoRepository.save(endereco);
//		//	enderecoClienteRepository.save(endereco);
//			System.out.println("Endereco Cadastrado");
//		//}else {
//			//System.out.println("Erro ao Cadastrar");
//		//}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataNasc = LocalDate.parse(data, formatter);

		Cliente cliente = new Cliente();
		//Telefone  telefone = new Telefone();
		//TipoTelefone tipoTelefone = new TipoTelefone();
		cliente.setNomeCliente(nomeCliente);
		cliente.setCpf(cpf);
		cliente.setDataNasc(dataNasc);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		cliente.setTelefone(salvarTelefone(sc));
		cliente.setEndereco(salvarEndereco(sc));
		
//		telefone.setNumero_telefone(telefoneCliente);
//		telefone.setDdd(dddTelefoneCliente);
//		telefone.setDescricao_telefone(descricaoTelefone);
		//tipoTelefone.setCod_tipo_telefone(codTelefoneCliente);
		//tipoTelefone.setDescricao_telefone(descricaoTipoTelefone);

		clienteRepository.save(cliente);
		//telefoneRepository.save(telefone);
		//tipoTelefoneRepository.save(tipoTelefone);
		System.out.println("Cliente Salvo com Sucesso");

	}
	
	
	
	private Telefone atualizarTelefone(Scanner sc, Telefone telefone) {
		System.out.println("Informe o novo Id do telefone a ser atualizado");
		Integer codTelefone = sc.nextInt();
		
		Telefone telefone1 = telefoneRepository.findById(codTelefone).get();
		
		System.out.println("Informe o novo tipo de telefone");
		String descricaoTelefone = sc.next();
		System.out.println("Informe o novo DDD");
		String ddd = sc.next();
		System.out.println("Informe o novo numero de telefone");
		String numeroTelefone = sc.next();
		
		
		telefone1.setDescricao_telefone(descricaoTelefone);
		telefone1.setDdd(ddd);
		telefone1.setNumero_telefone(numeroTelefone);
		
		telefoneRepository.save(telefone1);
		
		System.out.println("Telefone Alterado com Sucesso");
		return telefone1;
	}
	
	
	private List<Telefone> salvarTelefone(Scanner sc) {
		List<Telefone> telefones =new ArrayList<Telefone>();
		System.out.println("Informe o DDD do telefone");
		String ddd = sc.next();
		System.out.println("Informe o número do telefone");
		String numeroTelefone = sc.next();
		System.out.println("Informe o tipo de telefone [Celular/Telefone Fixo]");
		String descricaoTelefone = sc.next();
		
		Telefone telefone = new Telefone();
		telefone.setDdd(ddd);
		telefone.setNumero_telefone(numeroTelefone);
		telefone.setDescricao_telefone(descricaoTelefone);
		
		telefoneRepository.save(telefone);
		telefones.add(telefone);
		return telefones;
		
//		System.out.println("Telefone salvo com sucesso");
	}
	
	private List<Endereco> salvarEndereco(Scanner sc){
		List<Endereco> enderecos = new ArrayList<Endereco>();
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
		//if(optional.isPresent()) {
			Estado estado = optional.get();
			Endereco endereco = new Endereco();
			endereco.setNomeCidade(nomeCidade);
			endereco.setCep(cep);
			endereco.setNomeRua(nomeRua);
			endereco.setNumeroCasa(numeroCasa);
			endereco.setComplemento(complemento);
			endereco.setBairro(bairro);
			endereco.setPontoReferencia(pontoReferencia);
			endereco.setEstado(estado);
			enderecoRepository.save(endereco);
			enderecos.add(endereco);
			//System.out.println("Endereco Cadastrado");
			return enderecos;
			
		//}
	}
	
	
	private Endereco atualizarEndereco(Scanner sc, Endereco endereco) {
		System.out.println("Informe o Id do Endereco a ser atualizado");
		Integer codEndereco = sc.nextInt();
		
		Endereco endereco1 = enderecoRepository.findById(codEndereco).get();
		
		
//		System.out.println("Informe o novo nome da Cidade");
//		String nomeCidade = sc.next();
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
		
		
//		System.out.println("Informe o novo codigo do estado");
//		Integer codEstado = sc.nextInt();
//		
//		Optional<Estado> estado = estadoRepository.findById(codEstado);
//		Optional<Endereco> enderecos = enderecoRepository.findById(codEndereco);
		
		//endereco.setNomeCidade(nomeCidade);
		endereco1.setCep(cep);
		endereco1.setNomeRua(nomeRua);
		endereco1.setNumeroCasa(numeroCasa);
		endereco1.setComplemento(complemento);
		endereco1.setBairro(bairro);
		endereco1.setPontoReferencia(pontoReferencia);
		//endereco.setEstado(estado.get());
		
		//enderecoRepository.save(endereco1);
		
		
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
		enderecoRepository.save(endereco1);
		System.out.println("Endereco Atualizado com Sucesso");
		return endereco1;
	}

}
