package com.unialfa.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Folha {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "idFuncionario")
	private Funcionario funcionario;
	
	@Column(name = "DATA_FOLHA")
	private LocalDate competencia;
	
	private BigDecimal totalProventos;
	private BigDecimal totalDescontos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "folha", fetch = FetchType.EAGER)
	private List<ItemFolha> eventos = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public LocalDate getCompetencia() {
		return competencia;
	}

	public void setCompetencia(LocalDate competencia) {
		this.competencia = competencia;
	}

	public BigDecimal getTotalProventos() {
		return totalProventos;
	}

	public void setTotalProventos(BigDecimal totalProventos) {
		this.totalProventos = totalProventos;
	}

	public BigDecimal getTotalDescontos() {
		return totalDescontos;
	}

	public void setTotalDescontos(BigDecimal totalDescontos) {
		this.totalDescontos = totalDescontos;
	}

	public List<ItemFolha> getEventos() {
		return eventos;
	}

	public void setEventos(List<ItemFolha> eventos) {
		this.eventos = eventos;
	}
}
