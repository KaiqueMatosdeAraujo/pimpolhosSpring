package br.com.rd.pimpolhos.PimpolhosSpring.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Categoria;


@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{
	
}