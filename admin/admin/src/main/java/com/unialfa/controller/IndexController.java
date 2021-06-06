package com.unialfa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unialfa.repository.MarcaRepository;

@Controller
public class IndexController {
	
	@Autowired
	MarcaRepository repo;
	
	@RequestMapping("/")
	public String inicar(Model model) {
		
		model.addAttribute("titulo1","Minha Primeira Pagina HTML!");
		model.addAttribute("titulo2","Novo Funcionário");
		model.addAttribute("titulo3","Listar Funcionários");
		model.addAttribute("titulo4","Zodiaco");
		model.addAttribute("titulo5","Rotina Cálculo");
		model.addAttribute("marcas",repo.findAll());
		
		return"index";
	}
}
