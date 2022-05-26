package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.EnderecoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.dto.ItemPedidoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.form.EnderecoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.form.ItemPedidoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cliente;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Endereco;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Estado;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedido;
import br.com.rd.pimpolhos.PimpolhosSpring.model.ItemPedidoID;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.ClienteRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EnderecoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.EstadoRepository;

@Service
public class EnderecoService {

	@Autowired
	private final EnderecoRepository enderecoRepository;
	@Autowired
	private final EstadoRepository estadoRepository;
	@Autowired
	private final ClienteRepository clienteRepository;

	public  EnderecoService( EnderecoRepository  enderecoRepository, EstadoRepository estadoRepository, ClienteRepository clienteRepository) {
		this.enderecoRepository = enderecoRepository;
		this.estadoRepository = estadoRepository;
		this.clienteRepository = clienteRepository;
	}
	
	
	public void deletar(Integer cod_endereco) {
		enderecoRepository.deletarEndereco(cod_endereco);
	}

	public Endereco salvar(Endereco endereco, Integer codCliente) {
		Optional<Cliente> cliente = clienteRepository.findById(codCliente);
		List<Endereco> enderecos = new ArrayList<>();
		enderecos = cliente.get().getEndereco();
		return enderecoRepository.save(endereco);
	}
	
	@Transactional
	public EnderecoDTO insert(EnderecoForm enderecoForm) {
		Endereco endereco = new Endereco();
		endereco.setNomeCidade(enderecoForm.getNomeCidade());
		endereco.setCep(enderecoForm.getCep());
		endereco.setNomeRua(enderecoForm.getNomeRua());
		endereco.setNumeroCasa(enderecoForm.getNumeroCasa());
		endereco.setComplemento(enderecoForm.getComplemento());
		endereco.setBairro(enderecoForm.getBairro());
		endereco.setPontoReferencia(enderecoForm.getPontoReferencia());
		//endereco.setCliente(Integer.parseInt(enderecoForm.getCodCliente()));
		endereco = enderecoRepository.save(endereco);
		return new EnderecoDTO(endereco);
	}
	
}
