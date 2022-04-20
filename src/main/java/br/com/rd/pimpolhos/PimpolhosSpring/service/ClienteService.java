package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;




@Service
public class ClienteService {
	private final ClienteRepository clienteRepository;
	private Boolean sistema = true;

	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no Cargo");
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
		
		System.out.println("Cargo deletado com sucesso");

	}

	private void visualizar() {
		Iterable<Cliente> clientes = clienteRepository.findAll();
		clientes.forEach(cliente-> System.out.println(cliente));
	}

	private void atualizar(Scanner sc) {
		Integer id;
		String nomeCliente;
		
		System.out.println("Informe o Id do registro a ser atualizado");
		id = sc.nextInt();
		
		System.out.println("Informe a nova descrição para o Cargo");
		nomeCliente = sc.next();
		
		Cliente cliente = new Cliente();
		cliente.setCodCliente(id);
		cliente.setNomeCliente(nomeCliente);
		
		clienteRepository.save(cliente);
		
		System.out.println("Cargo Atualizado com Sucesso");

	}

	private void salvar(Scanner sc) {
		System.out.println("Informe a Descrição do Cargo");
		String nomeCliente = sc.next();
		String cpf = sc.next();
		String email = sc.next();
		String senha = sc.next();
		
		
		
		Cliente cliente = new Cliente();
		cliente.setNomeCliente(nomeCliente);
		cliente.setCpf(cpf);
		cliente.setEmail(email);
		cliente.setSenha(senha);


		clienteRepository.save(cliente);

		System.out.println("Cargo Salvo com Sucesso");

	}

}
