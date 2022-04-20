package br.com.rd.pimpolhos.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name="forma_pagamento")
public class FormaPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cod_forma_pagamento;
	
	@Column(nullable = false)
	@Length(max = 20)
	private String descricao_forma_pagamento;


	public Integer getCod_forma_pagamento() {
		return cod_forma_pagamento;
	}

	public void setCod_forma_pagamento(Integer cod_forma_pagamento) {
		this.cod_forma_pagamento = cod_forma_pagamento;
	}


	public String getDescricao_forma_pagamento() {
		return descricao_forma_pagamento;
	}

	public void setDescricao_forma_pagamento(String descricao_forma_pagamento) {
		this.descricao_forma_pagamento = descricao_forma_pagamento;
	}


	@Override
	public String toString() {
		return "FormaPagamento [cod_forma_pagamento=" + cod_forma_pagamento + ", descricao_forma_pagamento="
				+ descricao_forma_pagamento + "]";
	}

	
	
}
