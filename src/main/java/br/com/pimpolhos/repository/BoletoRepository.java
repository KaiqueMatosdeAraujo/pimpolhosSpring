package br.com.pimpolhos.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import br.com.rd.pimpolhos.model.Boleto;


@Repository
public interface BoletoRepository extends CrudRepository<Boleto, Integer>{
	
}