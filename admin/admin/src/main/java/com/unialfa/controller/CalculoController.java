package com.unialfa.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unialfa.model.Folha;
import com.unialfa.model.Funcionario;
import com.unialfa.repository.FolhaRepository;
import com.unialfa.repository.FuncionarioRepository;
import com.unialfa.service.FolhaSalarioService;

@Controller()
@RequestMapping("/calculo")
public class CalculoController {

	@Autowired
	FolhaSalarioService folhaSalario;

	@Autowired
	FuncionarioRepository funcRepo;

	@Autowired
	FolhaRepository folhaRepo;

	@GetMapping("/rotina")
	public String abrirRotina(Funcionario funcionario, Model model) {
		return "calculo/rotina";
	}

	@GetMapping("/holerite")
	public String abrirHolerite(Folha folha, Model model) {
		model.addAttribute(folha);
		return "calculo/holerite";
	}

	@GetMapping("/holerites")
	public String abrirHolerites(@PathParam(value = "id") Long id, Model model) {
		
		model.addAttribute(
				"folhas",
				folhaRepo.findByFuncionario(
						funcRepo.getOne(id)));
		
		
		return "calculo/lista";
	}
	
	@PostMapping("/calcular")
	public String calcular(
			Long idFuncionario,
			@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate competencia,
			BigDecimal dias,
			Model model) {

		Folha f = folhaSalario.calcularSalario(funcRepo.getOne(idFuncionario), competencia, dias);

		return abrirHolerite(f, model);
	}
}
