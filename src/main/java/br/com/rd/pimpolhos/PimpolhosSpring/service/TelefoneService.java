package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Telefone;
//import br.com.rd.pimpolhos.PimpolhosSpring.model.TipoTelefone;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.TelefoneRepository;

@Service
public class TelefoneService {

	@Autowired
	private final TelefoneRepository telefoneRepository;
	private Boolean sistema = true;
	
	
	public TelefoneService(TelefoneRepository telefoneRepository) {
		this.telefoneRepository = telefoneRepository;
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
		System.out.println("Informe o Id do telefone a ser deletado");
		int id = sc.nextInt();
		
		telefoneRepository.deleteById(id);
		
		System.out.println("Telefone deletado com sucesso");
	}
	
	private void visualizar() {
		Iterable<Telefone> telefones = telefoneRepository.findAll();
		telefones.forEach(telefone -> System.out.println(telefone));
	}
	
	private void atualizar(Scanner sc) {
		System.out.println("Informe o novo Id do telefone a ser atualizado");
		Integer codTelefone = sc.nextInt();
		//System.out.println("Informe o novo tipo de telefone");
		//TipoTelefone codTipoTelefone = sc.next();
		System.out.println("Informe o novo DDD");
		String ddd = sc.next();
		System.out.println("Informe o novo numero de telefone");
		String numeroTelefone = sc.next();
		
		Telefone telefone = new Telefone();
		//telefone.setTipoTelefone(codTipoTelefone);
		telefone.setDdd(ddd);
		telefone.setNumero_telefone(numeroTelefone);
	}
	
	private void salvar(Scanner sc) {
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
		
		System.out.println("Telefone salvo com sucesso");
	}
	
}
