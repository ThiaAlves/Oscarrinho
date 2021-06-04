package com.unialfa.controller;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unialfa.model.Funcionario;
import com.unialfa.repository.FolhaRepository;
import com.unialfa.repository.FuncionarioRepository;
import com.unialfa.service.FolhaSalarioService;
import com.unialfa.service.ZodiacoService;

@Controller
@RequestMapping("/funcionario")
public class FuncionarioController {
	
	@Autowired
	ZodiacoService zService;
	
	@Autowired
	FolhaSalarioService folhaSalario;
	
	@Autowired
	FuncionarioRepository repo;
	
	@Autowired
	FolhaRepository folhaRepo;
	
	@Autowired
	CalculoController calculo;

	@GetMapping("/formulario")
	public String abrirFormulario(Funcionario funcionario, Model model){
		return "funcionario/formulario";
	}
	
	@PostMapping("salvar")
	public String salvar(Funcionario funcionario) {
		repo.save(funcionario);
		return "redirect:lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(Funcionario funcionario) {
		repo.save(funcionario);
		return "redirect:../lista";
	}
	
	@RequestMapping("lista")
	public String abrirLista(Model model) {
		model.addAttribute("funcionarios",repo.findAll());
		return "funcionario/lista";
	}
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Funcionario f = repo.getOne(id);
		model.addAttribute("funcionario", f);
		
		model.addAttribute("signo", zService.descobrirSigno(f.getDataNascimento()));
		
		return "funcionario/formulario";
	}
	
	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id) {
		repo.deleteById(id);
		return "redirect:../lista";
	}

	@GetMapping(value = "calcular")
	public String calcularSalario(@PathParam(value = "id") Long id) {
		folhaSalario.calcularSalario(
				repo.getOne(id), 
				LocalDate.of(2021, 5, 1),
				BigDecimal.valueOf(30l));
		
		System.out.println(
				folhaRepo
				.queryFolhaMes(repo.getOne(id), LocalDate.of(2021, 5, 1))
				.getTotalProventos()
				);
		
		return "redirect:../lista";
	}
	
	@GetMapping(value = "abrirHolerite")
	public String abrirHolerites(@PathParam(value = "id") Long id, Model model) {
		return calculo.abrirHolerites(id, model);
	}
	
}
