package br.com.rd.pimpolhos.PimpolhosSpring.service;

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

	
	public Iterable<Produto> visualizar() {
		return produtoRepository.findAll();
	}
}
