package com.unialfa.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Evento {

	@Id
	private Long codigo;
	private String descricao;
	private TipoEvento tipo;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TipoEvento getTipo() {
		return tipo;
	}
	public void setTipo(TipoEvento tipo) {
		this.tipo = tipo;
	}
}
