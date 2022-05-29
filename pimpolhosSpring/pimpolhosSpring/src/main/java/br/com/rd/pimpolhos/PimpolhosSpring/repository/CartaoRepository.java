package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;


@Repository
public interface CartaoRepository extends CrudRepository<Cartao, Integer>,
											JpaRepository<Cartao, Integer>{

}
