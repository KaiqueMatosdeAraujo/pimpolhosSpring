package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Fornecedor;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	@Autowired
	private final FornecedorRepository fornecedorRepository;
	private Boolean sistema = true;
	
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	
	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada em Fornecedor?");
			System.out.println("0 - Sair");
			System.out.println("1 - Visualizar");

			acao = sc.nextInt();

			switch (acao) {
			case 1:
				visualizar();
				break;
			default:
				sistema = false;
				break;	
			}
		}
	}
	
	private void visualizar() {
		Iterable<Fornecedor> fornecedores = fornecedorRepository.findAll();
		fornecedores.forEach(fornecedor -> System.out.println(fornecedor));
	}
	
}
