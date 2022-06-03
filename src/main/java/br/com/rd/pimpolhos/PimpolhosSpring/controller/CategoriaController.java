package br.com.rd.pimpolhos.PimpolhosSpring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Categoria;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	
	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}

}
