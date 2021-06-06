package com.unialfa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String modelo;
	private String anomodelo;
	private String anofabricacao;
	private Float valor;
	private String tipo;
	private String fotodestaque;
	private Integer marca_id;
	private Integer cor_id;
	private Integer usuario_id;
	private String opcionais;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

    public String getModelo() {
		return modelo;
	}
    
    public void setModelo(String modelo) {
		this.modelo = modelo;
	}
    
    public String getAnomodelo() {
		return anomodelo;
	}
    
    public void setAnomodelo(String anomodelo) {
		this.anomodelo = anomodelo;
	}
    
    public String getAnofabricacao() {
		return anofabricacao;
	}
    
    public void setAnofabricacao(String anofabricacao) {
		this.anofabricacao = anofabricacao;
	}
    
    public Float getValor() {
		return valor;
	}
    
    public void setValor(Float valor) {
		this.valor = valor;
	}
    
    public String getTipo() {
		return tipo;
	}
    
    public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    public String getFotodestaque() {
		return fotodestaque;
	}
    
    public void setFotodestaque(String fotodestaque) {
		this.fotodestaque = fotodestaque;
	}
    
    public Integer getMarca_id() {
		return marca_id;
	}
    
    public void setMarca_id(Integer marca_id) {
		this.marca_id = marca_id;
	}
    
    public Integer getCor_id() {
		return cor_id;
	}
    
    public void setCor_id(Integer cor_id) {
		this.cor_id = cor_id;
	}
    
    public Integer getUsuario_id() {
		return usuario_id;
	}
    
    public void setUsuario_id(Integer usuario_id) {
		this.usuario_id = usuario_id;
	}
    
    public String getOpcionais() {
		return opcionais;
	}
    
    public void setOpcionais(String opcionais) {
		this.opcionais = opcionais;
	}
    
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " " + modelo + " " + anomodelo + " " + anofabricacao + " " + valor + " " + tipo
				+ " " + fotodestaque + " " + marca_id + " " + cor_id + " " + usuario_id + " " + opcionais;
	}
	

}
