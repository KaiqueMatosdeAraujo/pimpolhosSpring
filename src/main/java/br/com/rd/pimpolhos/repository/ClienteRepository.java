package br.com.rd.pimpolhos.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.rd.pimpolhos.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {


}
