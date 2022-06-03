package br.com.rd.pimpolhos.PimpolhosSpring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Estado;


@Repository
public interface EstadoRepository extends CrudRepository<Estado, Integer>{
	
	@Query(value="select * from estado", nativeQuery=true)
	List<Estado> findAll();
	
}