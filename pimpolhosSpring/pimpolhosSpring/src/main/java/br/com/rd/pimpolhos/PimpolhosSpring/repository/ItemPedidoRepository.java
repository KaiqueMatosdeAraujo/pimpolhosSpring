package br.com.rd.pimpolhos.PimpolhosSpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedidoID;

@Repository
public interface ItemPedidoRepository extends CrudRepository<ItemPedido, ItemPedidoID>,
												JpaRepository<ItemPedido, ItemPedidoID>{

}
