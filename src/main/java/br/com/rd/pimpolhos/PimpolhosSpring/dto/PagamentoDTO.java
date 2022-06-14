package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Boleto;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Cartao;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pagamento;
import br.com.rd.pimpolhos.PimpolhosSpring.model.Pix;

public class PagamentoDTO {

	private Integer codPagamento;
	private String formaPagamento;
	private Cartao cartao;
	private Boleto boleto;
	private Pix pix;

	
	
	public PagamentoDTO(Pagamento pagamento) {
		this.codPagamento = pagamento.getCodPagamento();
		this.formaPagamento = pagamento.getFormaPagamento().getDescricao();
		this.cartao = pagamento.getCartao();
		this.boleto = pagamento.getBoleto();
	    this.pix = pagamento.getPix();
	}


	public Integer getCodPagamento() {
		return codPagamento;
	}


	public void setCodPagamento(Integer codPagamento) {
		this.codPagamento = codPagamento;
	}


	public String getFormaPagamento() {
		return formaPagamento;
	}


	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}


	
	
	
	
	
	
	
	public Boleto getBoleto() {
		return boleto;
	}


	public void setBoleto(Boleto boleto) {
		this.boleto = boleto;
	}


	public Pix getPix() {
		return pix;
	}


	public void setPix(Pix pix) {
		this.pix = pix;
	}


	public Cartao getCartao() {
		return cartao;
	}


	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}


	public static List<PagamentoDTO> converter(List<Pagamento> pagamento){
		return pagamento.stream().map(PagamentoDTO::new).collect(Collectors.toList());
	}
	
	
	
}
