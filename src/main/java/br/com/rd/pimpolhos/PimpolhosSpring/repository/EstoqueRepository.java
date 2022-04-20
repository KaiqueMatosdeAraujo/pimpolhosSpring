package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Estoque;

@Repository
public interface EstoqueRepository extends CrudRepository<Estoque, Integer> {

}
