package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.BandeiraRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.CartaoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;

@Service
public class CartaoService {
	
	@Autowired
	private final CartaoRepository cartaoRepository;
	private final ClienteRepository clienteRepository;
	private final BandeiraRepository bandeiraRepository;
	private Boolean sistema = true;
	
	public CartaoService(CartaoRepository cartaoRepository, ClienteRepository clienteRepository, BandeiraRepository bandeiraRepository) {
		this.cartaoRepository = cartaoRepository;
		this.clienteRepository = clienteRepository;
		this.bandeiraRepository = bandeiraRepository;
	
	}

	

	public void deletar(Integer id) {
		cartaoRepository.deleteById(id);
	}

	
	public Iterable<Cartao> visualizar() {
		return cartaoRepository.findAll();
	}
	
	
	public Optional<Cartao> visualizarPorId(Integer id) {
		return cartaoRepository.findById(id);
		
	}

	
	@Transactional
	public Cartao atualizar(Integer id, Cartao cartaoAtualizado) {
		Cartao cartao = cartaoRepository.findById(id).get();
		
		cartao.setNomeTitular(cartaoAtualizado.getNomeTitular());
		
		
		return cartaoRepository.save(cartao);
	}
	
	
	public void salvar(Cartao cartao) {
		cartaoRepository.save(cartao);
	}
	
}