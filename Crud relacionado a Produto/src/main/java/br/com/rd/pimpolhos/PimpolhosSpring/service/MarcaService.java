package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Marca;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private final MarcaRepository marcaRepository;
	private Boolean sistema = true;
	
	public MarcaService(MarcaRepository marcaRepository) {
		this.marcaRepository = marcaRepository;
	}

	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada em Marca?");
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
		Iterable<Marca> marcas = marcaRepository.findAll();
		marcas.forEach(marca-> System.out.println(marca));
	}
	
}
