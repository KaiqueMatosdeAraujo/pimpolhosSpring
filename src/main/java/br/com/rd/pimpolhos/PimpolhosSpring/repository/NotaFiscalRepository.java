package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.NotaFiscal;



public interface NotaFiscalRepository extends CrudRepository<NotaFiscal , Integer>,
												JpaRepository<NotaFiscal, Integer>{

}
