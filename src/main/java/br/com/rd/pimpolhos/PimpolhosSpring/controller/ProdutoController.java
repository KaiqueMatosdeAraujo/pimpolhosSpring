package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.ProdutoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Produto;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ProdutoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.service.ProdutoService;



@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public Page<Produto> Listar(Pageable pageable ) {

		Page<Produto> produto = produtoService.visualizar(pageable);

		return produto;
	}
	
//	@GetMapping
//	public Page<ProdutoDTO> Listar(Pageable pageable ) {
//
//		Page<Produto> produto = produtoRepository.findAll(pageable);
//
//		return ProdutoDTO.converter(produto);
//	}
	
//	@GetMapping("/{id}")
//	public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable("id") Integer id){
//		Optional<Produto> produto = produtoRepository.findById(id);
//		List<Produto> produtos = new ArrayList<>();
//
//		return ResponseEntity.ok().body(new ProdutoDTO(produto.get()));
//	}
	
	@GetMapping("/{id}")
	public Optional<Produto> buscarPorId(@PathVariable("id") Integer id){
		return produtoService.visualizarPorId(id);
	}
	
	
	@RequestMapping(value = "/buscar", method = RequestMethod.GET)
	public ResponseEntity<List<Produto>> buscarProduto(@RequestParam(value = "nome", defaultValue = "") String nome ){
		List<Produto> produto = produtoService.buscarProduto(nome);
		return ResponseEntity.ok().body(produto);

	}
}
