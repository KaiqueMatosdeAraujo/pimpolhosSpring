package br.com.pimpolhos.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.rd.pimpolhos.model.ProdutosRelacionados;


@Repository
public interface ProdutosRelacionadosRepository extends CrudRepository<ProdutosRelacionados, Integer>{
	
}




