package br.com.rd.pimpolhos.PimpolhosSpring.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

//	
//	public List<Produto> visualizar() {
//		return produtoRepository.findAll();
//	}
	
	
	public Optional<Produto> visualizarPorId(Integer id){
		return produtoRepository.findById(id);
	}
	
	public Page<Produto> visualizar(Pageable pageable ) {
		return produtoRepository.findAll(pageable);
	}
	
	public List<Produto> buscarProduto(String nome){
		return produtoRepository.findByNomeContaining(nome);
	}
	
	public List<Produto> buscarCategoria (Integer cod_categoria){
		return produtoRepository.findAllByCategoria(cod_categoria);
	}
}
