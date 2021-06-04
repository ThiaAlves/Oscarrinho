package com.unialfa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Irrf {

	private BigDecimal referencia;
	private BigDecimal desconto;
	@SuppressWarnings("unused")
	private BigDecimal valor;
	private BigDecimal salario;

	public Irrf(BigDecimal salario) {
		this.salario = salario;

		if (salario.compareTo(BigDecimal.valueOf(1903.99d)) > -1
				&& salario.compareTo(BigDecimal.valueOf(2826.65d)) < 1) {
			referencia = BigDecimal.valueOf(7.5d);
			desconto = BigDecimal.valueOf(142.8d);

		} else if (salario.compareTo(BigDecimal.valueOf(2826.66d)) > -1
				&& salario.compareTo(BigDecimal.valueOf(3751.05d)) < 1) {
			referencia = BigDecimal.valueOf(15l);
			desconto = BigDecimal.valueOf(354.8d);

		} else if (salario.compareTo(BigDecimal.valueOf(3751.06d)) > -1
				&& salario.compareTo(BigDecimal.valueOf(4466.68d)) < 1) {
			referencia = BigDecimal.valueOf(22.5d);
			desconto = BigDecimal.valueOf(636.13d);

		} else if (salario.compareTo(BigDecimal.valueOf(4664.68d)) > -1) {
			referencia = BigDecimal.valueOf(27.5d);
			desconto = BigDecimal.valueOf(869.36d);
		}
	}
	
	public BigDecimal getReferencia() {
		return referencia;
	}
	
	public BigDecimal getValor() {
		return valor = salario
				.divide(BigDecimal.valueOf(100l), 6, RoundingMode.CEILING)
				.multiply(referencia)
				.subtract(desconto);
		
	}
}
