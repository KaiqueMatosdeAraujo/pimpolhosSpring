package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Telefone;
//import br.com.rd.pimpolhos.PimpolhosSpring.model.TipoTelefone;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.TelefoneRepository;
//import br.com.rd.pimpolhos.PimpolhosSpring.repository.TipoTelefoneRepository;
//import br.com.rd.pimpolhos.PimpolhosSpring.repository.TipoTelefoneRepository;


@Service
public class ClienteService {
	
	@Autowired
	private final ClienteRepository clienteRepository;
	private final TelefoneRepository telefoneRepository;
	//private final TipoTelefoneRepository tipoTelefoneRepository;
	private Boolean sistema = true;

	public ClienteService(ClienteRepository clienteRepository, TelefoneRepository telefoneRepository) {
		this.clienteRepository = clienteRepository;
		this.telefoneRepository = telefoneRepository;
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
		System.out.println("Informe o telefone do Cliente");
		String telefoneCliente = sc.next();
		System.out.println("Informe o DDD do telefone do Cliente");
		String dddTelefoneCliente = sc.next();
		System.out.println("Informe o tipo de telefone [Celular/Telefone Fixo]");
		String descricaoTelefone = sc.next();
		//Integer codTelefoneCliente = Integer.parseInt(sc.next());
	//	Optional<TipoTelefone> tiposTelefone = tipoTelefoneRepository.findById(codTelefoneCliente);

		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dataNasc = LocalDate.parse(data, formatter);

		Cliente cliente = new Cliente();
		Telefone  telefone = new Telefone();
		//TipoTelefone tipoTelefone = new TipoTelefone();
		cliente.setNomeCliente(nomeCliente);
		cliente.setCpf(cpf);
		cliente.setDataNasc(dataNasc);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		telefone.setNumero_telefone(telefoneCliente);
		telefone.setDdd(dddTelefoneCliente);
		telefone.setDescricao_telefone(descricaoTelefone);
		//tipoTelefone.setCod_tipo_telefone(codTelefoneCliente);
		//tipoTelefone.setDescricao_telefone(descricaoTipoTelefone);

		clienteRepository.save(cliente);
		telefoneRepository.save(telefone);
		//tipoTelefoneRepository.save(tipoTelefone);
		System.out.println("Cliente Salvo com Sucesso");

	}

}
