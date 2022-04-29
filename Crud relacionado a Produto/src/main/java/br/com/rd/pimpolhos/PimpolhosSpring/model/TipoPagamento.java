package br.com.rd.pimpolhos.PimpolhosSpring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipoPagamento")
public class TipoPagamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codOperacao;

//	private Integer codFormaPagamento;
	
	public Integer getCodOperacao() {
		return codOperacao;
	}

	public void setCodOperacao(Integer codOperacao) {
		this.codOperacao = codOperacao;
	}
	
	@Override
	public String toString() {
		return "Tipo de pagamento [codOperacao=" + codOperacao + "]" ;
	}
	
}
