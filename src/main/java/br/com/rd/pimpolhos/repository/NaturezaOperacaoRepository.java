package br.com.rd.pimpolhos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.model.NaturezaOperacao;

@Repository
public interface NaturezaOperacaoRepository extends CrudRepository<NaturezaOperacao, Integer> {

}
