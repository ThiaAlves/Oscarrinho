package com.unialfa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Inss {
	private BigDecimal referencia;
	@SuppressWarnings("unused")
	private BigDecimal valor;
	private BigDecimal salario;
	
	public Inss(BigDecimal salario) {
		this.salario = salario;
		
		if(salario.compareTo(BigDecimal.valueOf(1100l)) < 1) {
			referencia = BigDecimal.valueOf(7.5d);
		
		}else if(salario.compareTo(BigDecimal.valueOf(1100.01d)) > -1
				&& salario.compareTo(BigDecimal.valueOf(2203.48d)) < 1) {
			referencia = BigDecimal.valueOf(9l);
		
		}else if(salario.compareTo(BigDecimal.valueOf(2203.49d)) > -1
				&& salario.compareTo(BigDecimal.valueOf(3305.22d)) < 1) {
			referencia = BigDecimal.valueOf(12l);
		
		}else if(salario.compareTo(BigDecimal.valueOf(3305.23d)) > -1
				&& salario.compareTo(BigDecimal.valueOf(6433.57d)) < 1) {
			referencia = BigDecimal.valueOf(14l);
		}
	
	}
	
	public BigDecimal getValor() {
		return valor = salario
				.divide(BigDecimal.valueOf(100l), 6, RoundingMode.CEILING)
				.multiply(referencia);
	}
	
	public BigDecimal getReferencia() {
		return referencia;
	}

}
