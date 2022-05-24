package br.com.rd.pimpolhos.PimpolhosSpring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Integer>,
											JpaRepository<Cliente, Integer>{


}
