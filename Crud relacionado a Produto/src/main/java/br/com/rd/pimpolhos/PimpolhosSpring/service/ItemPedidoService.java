package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private final ItemPedidoRepository itemPedidoRepository;
	private Boolean sistema = true;
	
	public ItemPedidoService(ItemPedidoRepository itemPedidoRepository) {
		this.itemPedidoRepository = itemPedidoRepository;
	}
	
	public void iniciar(Scanner sc) {
		int acao;

		while (sistema) {
			System.out.println("Qual a ação que será realizada em Item pedido?");
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
		Iterable<ItemPedido> itensPedido = itemPedidoRepository.findAll();
		itensPedido.forEach(itemPedido -> System.out.println(itemPedido));
	}
}
