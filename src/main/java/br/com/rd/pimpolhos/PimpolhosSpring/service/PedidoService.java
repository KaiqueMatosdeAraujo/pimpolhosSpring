package br.com.rd.pimpolhos.PimpolhosSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private final PedidoRepository pedidoRepository;

	public PedidoService(PedidoRepository pedidoRepository) {
		super();
		this.pedidoRepository = pedidoRepository;
	}
	
	
	public Iterable<Pedido> visualizar(){
		return pedidoRepository.findAll();
	}
	
	public void salvar(Pedido pedido) {
		pedidoRepository.save(pedido);
	}

}