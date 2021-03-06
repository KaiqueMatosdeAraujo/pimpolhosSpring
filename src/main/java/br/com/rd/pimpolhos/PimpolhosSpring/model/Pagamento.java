package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="pagamento")
public class Pagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codPagamento;
	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "codPedido")
//	private Pedido pedido;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codFormaPagamento")
	private FormaPagamento formaPagamento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codCartao")
	private Cartao cartao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codBoleto")
	private Boleto boleto;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codPix")
	private Pix pix;
	

	public Pagamento() {

	}


	public Pagamento(Integer codPagamento, FormaPagamento formaPagamento, Cartao cartao, Boleto boleto,
			Pix pix) {
		super();
		this.codPagamento = codPagamento;
		this.formaPagamento = formaPagamento;
		this.cartao = cartao;
		this.boleto = boleto;
		this.pix = pix;
	}



	public Integer getCodPagamento() {
		return codPagamento;
	}
	
	public void setCodPagamento(Integer codPagamento) {
		this.codPagamento = codPagamento;
	}
	

	

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
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
	
	
	
	
}
