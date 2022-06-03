package br.com.rd.pimpolhos.PimpolhosSpring.form;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.CartaoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Bandeira;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.BandeiraRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;

public class CartaoForm {

	
	private String numeroCartao;
	private String nomeTitular;
	private String validade;
	private Integer bandeira;
	private Integer cliente;
	
	public CartaoForm(String numeroCartao, String nomeTitular, String validade, String bandeira, String cliente) {
		this.numeroCartao = numeroCartao;
		this.nomeTitular = nomeTitular;
		this.validade = validade;
		this.bandeira = Integer.parseInt(bandeira);
		this.cliente = Integer.parseInt(cliente);
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getNomeTitular() {
		return nomeTitular;
	}

	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public Integer getBandeira() {
		return bandeira;
	}

	public void setBandeira(Integer bandeira) {
		this.bandeira = bandeira;
	}
	
	
	
	public Integer getCliente() {
		return cliente;
	}

	public void setCliente(Integer cliente) {
		this.cliente = cliente;
	}

	public Cartao converter(BandeiraRepository bandeiraRepository, ClienteRepository clienteRepository) {
		Cartao cartao = new Cartao(numeroCartao, nomeTitular, validade);
		Optional<Bandeira>bandeira = bandeiraRepository.findById(this.bandeira);
		Optional<Cliente> cliente = clienteRepository.findById(this.cliente);
		cartao.setBandeira(bandeira.get());
		cartao.setCliente(cliente.get());
		return cartao;
	}
	
	
	public List<CartaoDTO> cadastrar(Cartao cartao, Cliente cliente, ClienteRepository clienteRepository){
		List<Cartao> cartoes;
		cartoes = cliente.getCartao();
		cartoes.add(cartao);
		cliente.setCartao(cartoes);
		clienteRepository.save(cliente);
		return CartaoDTO.converter(cartoes);
	}
	
}
