package br.com.rd.pimpolhos.PimpolhosSpring.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.rd.pimpolhos.PimpolhosSpring.model.Estado;

public class EstadoDTO {
	
	private Integer cod_estado;
	private String descricao_estado;
	
	public EstadoDTO(Estado estado) {

		this.cod_estado = estado.getCod_estado();
		this.descricao_estado = estado.getDescricao_estado();
	}

	public Integer getCod_estado() {
		return cod_estado;
	}

	public String getDescricao_estado() {
		return descricao_estado;
	}

	public void setCod_estado(Integer cod_estado) {
		this.cod_estado = cod_estado;
	}

	public void setDescricao_estado(String descricao_estado) {
		this.descricao_estado = descricao_estado;
	}
	
	public static List<EstadoDTO> converter (List<Estado> estados) {
		return estados.stream().map(EstadoDTO::new).collect(Collectors.toList());
	}  
	
}