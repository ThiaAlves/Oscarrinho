package com.unialfa.model;

public class Curriculo {
	private int ra;
	private String nome;
	private String curso;
	private String empresa;
	private String funcao;
	private int tempoMeses;
	private String projeto;

	public Curriculo() {
		// TODO Auto-generated constructor stub
	}
	
	public Curriculo(int ra, String nome, String curso, String empresa, String funcao, int tempoMeses, String projeto) {
		super();
		this.ra = ra;
		this.nome = nome;
		this.curso = curso;
		this.empresa = empresa;
		this.funcao = funcao;
		this.tempoMeses = tempoMeses;
		this.projeto = projeto;
	}
	
	public int getRa() {
		return ra;
	}
	public void setRa(int ra) {
		this.ra = ra;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getTempoMeses() {
		return tempoMeses;
	}
	public void setTempoMeses(int tempoMeses) {
		this.tempoMeses = tempoMeses;
	}
	public String getProjeto() {
		return projeto;
	}
	public void setProjeto(String projeto) {
		this.projeto = projeto;
	}

}