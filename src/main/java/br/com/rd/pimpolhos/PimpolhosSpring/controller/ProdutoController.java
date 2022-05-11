package br.com.rd.pimpolhos.PimpolhosSpring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Produto;
import br.com.rd.pimpolhos.PimpolhosSpring.service.ProdutoService;



@RestController
@RequestMapping("/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public List<Produto> Listar() {

		List<Produto> produto = produtoService.visualizar();

		return produto;
	}
	
	@GetMapping("/{id}")
	public Optional<Produto> buscarPorId(@PathVariable("id") Integer id){
		return produtoService.visualizarPorId(id);
	}
}
