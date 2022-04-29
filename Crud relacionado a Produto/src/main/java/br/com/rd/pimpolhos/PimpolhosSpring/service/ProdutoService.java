package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Produto;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private final ProdutoRepository produtoRepository;
	private Boolean sistema = true;
	
	public ProdutoService(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada em Produto");
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
		Iterable<Produto> produtos = produtoRepository.findAll();
		produtos.forEach(produto -> System.out.println(produto));
	}
	
}
