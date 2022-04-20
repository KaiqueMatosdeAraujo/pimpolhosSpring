package br.com.rd.pimpolhos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.model.ItemNf;

@Repository
public interface ItemNfRepository extends CrudRepository<ItemNf, Integer>{

}
