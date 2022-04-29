package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Categoria;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private final CategoriaRepository categoriaRepository;
	private Boolean sistema = true;
	
	public CategoriaService(CategoriaRepository categoriaRepository) {
		this.categoriaRepository = categoriaRepository;
	}
	
	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada em Categoria?");
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
		Iterable<Categoria> categorias = categoriaRepository.findAll();
		categorias.forEach(categoria -> System.out.println(categoria));
	}
	
}
	

