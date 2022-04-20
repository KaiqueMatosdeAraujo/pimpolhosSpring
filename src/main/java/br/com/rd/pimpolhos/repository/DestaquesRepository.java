package br.com.rd.pimpolhos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.model.Destaques;

@Repository
public interface DestaquesRepository extends CrudRepository<Destaques, Integer>{

}
