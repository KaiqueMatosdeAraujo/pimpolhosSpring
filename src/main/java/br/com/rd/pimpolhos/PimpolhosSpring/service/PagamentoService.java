package br.com.rd.pimpolhos.PimpolhosSpring.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.rd.pimpolhos.PimpolhosSpring.dto.PagamentoDTO;
import br.com.rd.pimpolhos.PimpolhosSpring.form.PagamentoForm;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Boleto;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.model.FormaPagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pix;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.BoletoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.CartaoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.FormaPagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PagamentoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PedidoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.PixRepository;

@Service
public class PagamentoService {

	@Autowired
	private final PagamentoRepository pagamentoRepository;
	@Autowired
	private final FormaPagamentoRepository formaPagamentoRepository;
	@Autowired
	private final CartaoRepository cartaoRepository;
	@Autowired
	private final BoletoRepository boletoRepository;
	@Autowired
	private final PixRepository pixRepository;

	
	
	
	



	public PagamentoService(PagamentoRepository pagamentoRepository, FormaPagamentoRepository formaPagamentoRepository,
			CartaoRepository cartaoRepository, BoletoRepository boletoRepository, PixRepository pixRepository) {
		this.pagamentoRepository = pagamentoRepository;
		this.formaPagamentoRepository = formaPagamentoRepository;
		this.cartaoRepository = cartaoRepository;
		this.boletoRepository = boletoRepository;
		this.pixRepository = pixRepository;
	}

	public Iterable<Pagamento> visualizar(){
		return pagamentoRepository.findAll();
	}
	
	public Pagamento salvar(Pagamento pagamento) {
		return pagamentoRepository.save(pagamento);
	}
	
	public PagamentoDTO cadastrar (PagamentoForm form) {
		
		Pagamento pagamento = new Pagamento();
		Optional <FormaPagamento> fp = formaPagamentoRepository.findById(Integer.parseInt(form.getFormaPagamento()));
//	    Optional <Cartao> cartao = cartaoRepository.findById(Integer.parseInt(form.getCartao()));
//	    Optional <Boleto> boleto = boletoRepository.findById(Integer.parseInt(form.getBoleto()));
//	    Optional <Pix> pix = pixRepository.findById(Integer.parseInt(form.getPix()));
		
		// Verificação do Pagamento de cartão
		
		
		if(cartaoRepository.findById(Integer.parseInt(form.getCartao())) != null) {
		Optional <Cartao> cartao = cartaoRepository.findById(Integer.parseInt(form.getCartao()));
			if(fp.isPresent() && cartao.isPresent()) {
			  pagamento.setFormaPagamento(fp.get());
			  pagamento.setCartao(cartao.get());
			  pagamento = pagamentoRepository.save(pagamento);
			}else {
				 fp.orElseThrow();
				 cartao.orElseThrow();
				 
			 }
		
	
		
		
		}
		// Verificação do Pagamento de cartão (final)
		
		
		
		// Verificação do Pagamento de boleto
		else if(boletoRepository.findById(Integer.parseInt(form.getBoleto())) != null) {
			Optional <Boleto> boleto = boletoRepository.findById(Integer.parseInt(form.getBoleto()));
			if(fp.isPresent() && boleto.isPresent() ) {
				 pagamento.setFormaPagamento(fp.get());
				 pagamento.setBoleto(boleto.get());
				 pagamento = pagamentoRepository.save(pagamento);
			 }else {
					 fp.orElseThrow();
					 boleto.orElseThrow();
				 
			 }
		
		
		
		
		}
		// Verificação do Pagamento de boleto (final)
			
			
		// Verificação do Pagamento de pix
		else if (pixRepository.findById(Integer.parseInt(form.getPix())) != null) {
			Optional <Pix> pix = pixRepository.findById(Integer.parseInt(form.getPix()));
			
			 if(fp.isPresent() && pix.isPresent() ) {
				 pagamento.setFormaPagamento(fp.get());
				 pagamento.setPix(pix.get());
				 pagamento = pagamentoRepository.save(pagamento);
			 }else {
				 fp.orElseThrow();
				 pix.orElseThrow();
				 
			 }
			 
			}
		
		return new PagamentoDTO(pagamento);
	}
	}
		
			
			
			
			
			
			

	
	

	
