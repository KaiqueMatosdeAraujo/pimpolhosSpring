package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Fornecedor;

@Repository
public interface FornecedorRepository extends CrudRepository<Fornecedor, Integer>{

}
