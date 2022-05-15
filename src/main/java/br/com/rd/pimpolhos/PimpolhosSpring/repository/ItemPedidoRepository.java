package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;

public interface ItemPedidoRepository extends CrudRepository<ItemPedido, Integer>,
												JpaRepository<ItemPedido, Integer>{

}
