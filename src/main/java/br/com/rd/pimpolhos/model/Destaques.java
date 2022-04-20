package br.com.rd.pimpolhos.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="destaque")
public class Destaques {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codDestaques;

	@Column(nullable = false)
	private String codPedido;

	public Integer getCodDestaques() {
		return codDestaques;
	}

	public void setCodDestaques(Integer codDestaques) {
		this.codDestaques = codDestaques;
	}

	public String getCodPedido() {
		return codPedido;
	}

	public void setCodPedido(String codPedido) {
		this.codPedido = codPedido;
	}

	@Override
	public String toString() {
		return "Destaques [codDestaques=" + codDestaques + ", codPedido=" + codPedido + "]";
	}


}
	