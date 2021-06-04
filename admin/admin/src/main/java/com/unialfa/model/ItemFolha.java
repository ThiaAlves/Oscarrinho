package com.unialfa.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemFolha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "idFolha")
	private Folha folha;
	
	@ManyToOne
	@JoinColumn(name = "idEvento")
	private Evento evento;
	
	private BigDecimal referencia;
	private BigDecimal valor;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Folha getFolha() {
		return folha;
	}
	public void setFolha(Folha folha) {
		this.folha = folha;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public BigDecimal getReferencia() {
		return referencia;
	}
	public void setReferencia(BigDecimal referencia) {
		this.referencia = referencia;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
		
}
