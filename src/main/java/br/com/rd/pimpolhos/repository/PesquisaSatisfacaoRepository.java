package br.com.rd.pimpolhos.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.model.PesquisaSatisfacao;

@Repository
public interface PesquisaSatisfacaoRepository extends CrudRepository<PesquisaSatisfacao, Integer> {

}
