package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.ItemPedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.form.ItemPedidoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedidoID;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	@Autowired
	private ItemPedidoRepository itemRepository;
	
	@Transactional(readOnly = true)
	public List<ItemPedidoDTO> findAll(){
		List <ItemPedido> list = itemRepository.findAll();
		return list.stream().map(x-> new ItemPedidoDTO(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public ItemPedidoDTO insert(ItemPedidoForm form) {
		ItemPedido entity = new ItemPedido();
		ItemPedidoID id = new ItemPedidoID();
        
		id.setCodPedido(Integer.parseInt(form.getCodPedido()));
		id.setCodProduto(Integer.parseInt(form.getCodProduto()));

		entity.setItemPedidoId(id);
		entity.setQuantidade(Integer.parseInt(form.getQuantidade()));
		entity = itemRepository.save(entity);
	
		return new ItemPedidoDTO(entity);

	}

}