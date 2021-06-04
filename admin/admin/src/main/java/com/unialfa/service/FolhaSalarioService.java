package com.unialfa.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unialfa.model.Folha;
import com.unialfa.model.Funcionario;
import com.unialfa.model.ItemFolha;
import com.unialfa.model.TipoEvento;
import com.unialfa.repository.EventoRepository;
import com.unialfa.repository.FolhaRepository;

@Service
public class FolhaSalarioService {

	@Autowired
	EventoRepository eventoRepo;
	
	@Autowired
	FolhaRepository folhaRepo;
	
	public Folha calcularSalario(Funcionario funcionario,
			LocalDate competencia, 
			BigDecimal referencia) {

		Folha folhaSalario = new Folha();
		
		folhaSalario.setFuncionario(funcionario);
		folhaSalario.setCompetencia(competencia);
		folhaSalario.getEventos().add(
				calcularEventoSalario(funcionario, folhaSalario, referencia));
		folhaSalario.getEventos().add(
				calcularInss(funcionario, folhaSalario));
		folhaSalario.getEventos().add(
				calcularIrrf(funcionario, folhaSalario));
		folhaSalario.getEventos().add(
				calcularFgts(funcionario, folhaSalario));
		
		return folhaRepo.save(calcularTotais(folhaSalario));
		
	}
	
	private Folha calcularTotais(Folha folha) {
		BigDecimal totalProventos = BigDecimal.ZERO;
		BigDecimal totalDescontos = BigDecimal.ZERO;
		
		for(ItemFolha i:folha.getEventos()) {
			if(i.getEvento().getTipo().equals(TipoEvento.PROVENTO))
				totalProventos = totalProventos.add(i.getValor());
			
			if(i.getEvento().getTipo().equals(TipoEvento.DESCONTO))
				totalDescontos = totalDescontos.add(i.getValor());
		}
		
		folha.setTotalProventos(totalProventos);
		folha.setTotalDescontos(totalDescontos);
		
		return folha;
	}
	
	private ItemFolha calcularEventoSalario(Funcionario funcionario,
			Folha folha, 
			BigDecimal referencia) {
		
		ItemFolha eventoSalario = new ItemFolha();
		
		eventoSalario.setEvento(eventoRepo.getOne(1l));
		eventoSalario.setFolha(folha);
		eventoSalario.setReferencia(referencia);
		
		BigDecimal salarioDia = funcionario.getSalario().
				divide(BigDecimal.valueOf(30l),6,RoundingMode.CEILING);
		
		eventoSalario.setValor(salarioDia.multiply(referencia));
			
		return eventoSalario;
	}
	
	private ItemFolha calcularInss(Funcionario func, Folha folha){
		Inss inss = new Inss(func.getSalario());
		
		ItemFolha eventoInss = new ItemFolha();
		
		eventoInss.setEvento(eventoRepo.getOne(2l));
		eventoInss.setFolha(folha);
		eventoInss.setReferencia(inss.getReferencia());
		eventoInss.setValor(inss.getValor());

		return eventoInss;
	}
	
	private ItemFolha calcularIrrf(Funcionario func, Folha folha){
		Irrf irrf = new Irrf(func.getSalario());
		
		ItemFolha evento = new ItemFolha();
		
		evento.setEvento(eventoRepo.getOne(3l));
		evento.setFolha(folha);
		evento.setReferencia(irrf.getReferencia());
		evento.setValor(irrf.getValor());

		return evento;
	}
	
	private ItemFolha calcularFgts(Funcionario func, Folha folha) {
		ItemFolha evento = new ItemFolha();
		
		evento.setEvento(eventoRepo.getOne(4l));
		evento.setFolha(folha);
		evento.setReferencia(BigDecimal.valueOf(8l));
		evento.setValor(func.getSalario()
				.divide(BigDecimal.valueOf(100l), 6, RoundingMode.CEILING)
				.multiply(BigDecimal.valueOf(8l)));
		return evento;
	}
}
