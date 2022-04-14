package br.com.pimpolhos.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.rd.pimpolhos.model.Estado;


@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer>{
	
}




