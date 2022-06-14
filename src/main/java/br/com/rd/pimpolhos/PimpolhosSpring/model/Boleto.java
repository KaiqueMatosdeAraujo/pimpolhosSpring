package br.com.rd.pimpolhos.PimpolhosSpring.model;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="boleto")
public class Boleto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBoleto;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@Size(max=50)
	@Column(nullable = false)
	private String codBarras;
	
	@Column(nullable = false)
	private LocalDate dataEmissao = LocalDate.now(); 
	
	@Column(nullable = false)
	private LocalDate dataVencimento;
	
	@Size(max=50)
	@Column(nullable = false)
	private String beneficiario;
	
	@Size(max=50)
	@Column(nullable = false)
	private String emissor;
	
//	@ManyToOne(fetch = FetchType.EAGER) 
//	@JoinColumn(name = "codOperacao") 
//	private TipoPagamento tipoPagamento;



	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public LocalDate getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDate dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getEmissor() {
		return emissor;
	}

	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}

	@Override
	public String toString() {
		return "Boleto [valor=" + valor + ", codBarras=" + codBarras + ", dataVencimento=" + dataVencimento
				+ ", beneficiario=" + beneficiario + ", emissor=" + emissor + "]";
	}

	
	
		

}
	