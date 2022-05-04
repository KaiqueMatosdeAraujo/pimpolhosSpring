package br.com.rd.pimpolhos.PimpolhosSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PagamentoRepository;

@Service
public class PagamentoService {

	@Autowired
	private final PagamentoRepository pagamentoRepository;

	public PagamentoService(PagamentoRepository pagamentoRepository) {
		super();
		this.pagamentoRepository = pagamentoRepository;
	}
	
	
	public Iterable<Pagamento> visualizar(){
		return pagamentoRepository.findAll();
	}
	
	public void salvar(Pagamento pagamento) {
		pagamentoRepository.save(pagamento);
	}
}
