package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.List;
import java.util.Optional;

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

	
	public List<Produto> visualizar() {
		return produtoRepository.findAll();
	}
	
	
	public Optional<Produto> visualizarPorId(Integer id){
		return produtoRepository.findById(id);
	}
}
