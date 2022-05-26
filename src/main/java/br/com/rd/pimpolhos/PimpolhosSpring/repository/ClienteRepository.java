package br.com.rd.pimpolhos.PimpolhosSpring.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>,
											JpaRepository<Cliente, Integer>{

	List<Cliente>findAll();
	
	Cliente findByCodCliente(Integer idCliente);
	
	Optional<Cliente> findByEmail(String email);
	
//	Optional<Cliente> findByNome(String nome);
//	
	@Query("SELECT ec FROM Cliente ec WHERE ec.email = :email")
	Cliente getClienteByEmail(@Param("email")String email);
}
