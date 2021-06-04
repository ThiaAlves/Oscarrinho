package com.unialfa.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

@Service
public class ZodiacoService {

	public String descobrirSigno(LocalDate data) {
		
		int dia = data.getDayOfMonth();
		int mes = data.getMonthValue();

		if ((mes == 1 && dia >= 20) || (mes == 2 && dia <= 18)) {
			return "AQUARIO";
		} else if ((mes == 2 && dia >= 19) || (mes == 3 && dia <= 20)) {
			return "PEIXES";
		} else if ((mes == 3 && dia >= 21) || (mes == 4 && dia <= 19)) {
			return "ARIES";
		} else if ((mes == 4 && dia >= 20) || (mes == 5 && dia <= 20)) {
			return "TOURO";
		} else if ((mes == 5 && dia >= 21) || (mes == 6 && dia <= 20)) {
			return "GEMEOS";
		} else if ((mes == 6 && dia >= 21) || (mes == 7 && dia <= 22)) {
			return "CANCER";
		} else if ((mes == 7 && dia >= 23) || (mes == 8 && dia <= 22)) {
			return "LEAO";
		} else if ((mes == 8 && dia >= 23) || (mes == 9 && dia <= 22)) {
			return "VIRGEM";
		} else if ((mes == 9 && dia >= 23) || (mes == 10 && dia <= 22)) {
			return "LIBRA";
		} else if ((mes == 10 && dia >= 23) || (mes == 11 && dia <= 21)) {
			return "ESCORPIAO";
		} else if ((mes == 11 && dia >= 22) || (mes == 12 && dia <= 21)) {
			return "SAGITARIO";
		} else if ((mes == 12 && dia >= 22) || (mes == 1 && dia <= 19)) {
			return "CAPRICORNIO";
		}

		return "";
	}
			
	public String descobrirElementoSigno(String signo) {
		if(signo == "LIBRA" || signo == "AQUARIO" || signo == "GEMEOS" ) {
			return"AR";
		}else if(signo == "CAPRICORNIO" || signo == "TOURO" || signo == "VIRGEM" ) {
			return"TERRA";
		}else if(signo == "ARIES" || signo == "LEAO" || signo == "SAGITARIO" ) {
			return"FOGO";
		}else if(signo == "CANCER" || signo == "ESCORPIAO" || signo == "PEIXES" ) {
			return"AGUA";
		}
		
		return"";
	}
	
}
