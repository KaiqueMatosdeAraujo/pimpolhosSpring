package br.com.rd.pimpolhos.PimpolhosSpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.NotaFiscalDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.NotaFiscal;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.NaturezaOperacaoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.NotaFiscalRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ProdutoRepository;

@Service
public class NotaFiscalService {

	@Autowired
	private NotaFiscalRepository notaFiscalRepository;
	private ProdutoRepository produtoRepository;
	private PedidoRepository pedidoRepository;
	private NaturezaOperacaoRepository naturezaOperacaoRepository;


	public NotaFiscalService(NotaFiscalRepository notaFiscalRepository, ProdutoRepository produtoRepository,
			PedidoRepository pedidoRepository, NaturezaOperacaoRepository naturezaOperacaoRepository) {
		super();
		this.notaFiscalRepository = notaFiscalRepository;
		this.produtoRepository = produtoRepository;
		this.pedidoRepository = pedidoRepository;
		this.naturezaOperacaoRepository = naturezaOperacaoRepository;
	}


	public Iterable<NotaFiscal> visualizar() {
		return notaFiscalRepository.findAll();
	}
	
	
	public NotaFiscal salvar(NotaFiscal notaFiscal) {
		return notaFiscalRepository.save(notaFiscal);
	}
	
}
