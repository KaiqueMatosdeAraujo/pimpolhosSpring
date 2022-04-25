package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Telefone;
import br.com.rd.pimpolhos.PimpolhosSpring.model.TipoTelefone;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.TelefoneRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.TipoTelefoneRepository;

@Service
public class TelefoneService {
	
	private TipoTelefoneRepository ttRepository;
	private TelefoneRepository     telRepository;
	private Boolean sistema = true;
	
	
	
	public TelefoneService(TipoTelefoneRepository ttRepository, TelefoneRepository telRepository) {
		super();
		this.ttRepository = ttRepository;
		this.telRepository = telRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada no telefone");
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
		
		telRepository.deleteById(id);
		
		System.out.println("Cargo deletado com sucesso");

	}

	private void visualizar() {
		Iterable<Telefone> tels = telRepository.findAll();
		for (Telefone telefone : tels) {
			System.out.println(telefone);
		}

	}

	private void atualizar(Scanner sc) {


	}

	private void salvar(Scanner sc) {
		
		System.out.println("Informe o DDD do telefone");
		String ddd = sc.next();
		
		System.out.println("Informe o numero do telefone");
		String numero = sc.next();
		
		System.out.println("Digite 1 para telefone fisico e 2 para Celular");
		Integer tipo = sc.nextInt();
		
		Optional<TipoTelefone> optional = ttRepository.findById(tipo);
		if(optional.isPresent()) {
			TipoTelefone tTelefone = optional.get();
			Telefone tel = new Telefone(ddd, numero, tTelefone);
			telRepository.save(tel);
			System.out.println("Telefone Cadastrado");
		}else {
		
		

		System.out.println("Erro ao Cadastrar");
		}
	}

	
	

}
