package br.com.rd.pimpolhos.PimpolhosSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.BoletoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.FormaPagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;

@Service
public class PagamentoService {

	@Autowired
	private final PagamentoRepository pagamentoRepository;
	private final FormaPagamentoRepository formaPagamentoRepository;
	private final PedidoRepository pedidoRepository;
	private final BoletoRepository boletoRepository;

	
	
	
	public PagamentoService(PagamentoRepository pagamentoRepository, FormaPagamentoRepository formaPagamentoRepository, BoletoRepository boletoRepository, PedidoRepository pedidoRepository) {
		super();
		this.pagamentoRepository = pagamentoRepository;
		this.formaPagamentoRepository = formaPagamentoRepository;
		this.boletoRepository = boletoRepository;
		this.pedidoRepository = pedidoRepository;
	}

	public Iterable<Pagamento> visualizar(){
		return pagamentoRepository.findAll();
	}
	
	public Pagamento salvar(Pagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}
}
