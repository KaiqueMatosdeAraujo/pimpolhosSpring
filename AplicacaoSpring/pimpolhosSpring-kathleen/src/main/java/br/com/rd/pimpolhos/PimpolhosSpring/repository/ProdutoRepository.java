package br.com.rd.pimpolhos.PimpolhosSpring.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
					
	@Query ("select p from Produto p where p.nome like %?1%")
	 	List<Produto> findByNomeContaining(String nome);

	
	@Query("select p from Produto p inner join p.categoria c where c.cod_categoria = :cod_categoria")
		List<Produto> findAllByCategoria(@Param("cod_categoria")Integer cod_categoria); 
	
}