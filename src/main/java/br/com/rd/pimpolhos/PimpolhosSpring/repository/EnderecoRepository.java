package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, Integer>,
												JpaRepository<Endereco, Integer>{

	List<Endereco> findByClienteCodCliente(@Valid Integer codCliente);
}
