package br.com.rd.pimpolhos.PimpolhosSpring.form;

import java.util.Optional;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.model.FormaPagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.CartaoRepository;
import br.com.rd.pimpolhos.PimpolhosSpring.repository.FormaPagamentoRepository;

public class PagamentoForm {
	
	private String formaPagamento;
	
	private String cartao;
	
	private String boleto;
	
	private String pix;
	
	
	



	


	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getCartao() {
		return cartao;
	}

	public void setCartao(String cartao) {
		this.cartao = cartao;
	}

	public String getBoleto() {
		return boleto;
	}

	public void setBoleto(String boleto) {
		this.boleto = boleto;
	}

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
	}
	


	
	
}
