package br.com.rd.pimpolhos.PimpolhosSpring.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="bandeira")
public class Bandeira {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codBandeira;
	
	@Column(nullable = false)
	@Length(max = 20)
	private String descricaoBandeira;

	
	public Integer getCodBandeira() {
		return codBandeira;
	}

	public void setCodBandeira(Integer codBandeira) {
		this.codBandeira = codBandeira;
	}

	public String getDescricaoBandeira() {
		return descricaoBandeira;
	}

	public void setDescricaoBandeira(String descricaoBandeira) {
		this.descricaoBandeira = descricaoBandeira;
	}





	@Override
	public String toString() {
		return "Bandeira [descricaoBandeira=" + descricaoBandeira + "]";
	}

	

	
	
}
