package br.com.rd.pimpolhos.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_estado;

	@Column(nullable = false)
	private String descricao_estado;

	public Integer getCod_estado() {
		return cod_estado;
	}

	public void setCod_estado(Integer cod_estado) {
		this.cod_estado = cod_estado;
	}

	public String getDescricao_estado() {
		return descricao_estado;
	}

	public void setDescricao_estado(String descricao_estado) {
		this.descricao_estado = descricao_estado;
	}

	@Override
	public String toString() {
		return "Estado [cod_estado=" + cod_estado + ", descricao_estado=" + descricao_estado + "]";
	}

}
	