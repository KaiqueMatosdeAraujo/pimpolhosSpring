package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer>,
												JpaRepository<Endereco, Integer>{

	List<Endereco> findByClienteCodCliente(@Valid Integer codCliente);
	
	@Query(value="delete endereco_cliente, endereco from endereco_cliente inner join endereco ON endereco_cliente.cod_endereco = endereco.cod_endereco where endereco.cod_endereco = :cod_endereco", nativeQuery=true)
	List<Endereco> deletarEndereco(@Param("cod_endereco")Integer cod_endereco);
	
}