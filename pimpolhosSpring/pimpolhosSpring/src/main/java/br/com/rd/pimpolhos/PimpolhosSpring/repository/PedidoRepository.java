package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Integer>,
											JpaRepository<Pedido, Integer>{
	
	List<Pedido> findByClienteCodCliente(@Valid Integer codCliente);
}