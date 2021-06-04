package com.unialfa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	
	@RequestMapping("/")
	public String inicar(Model model) {
		
		model.addAttribute("titulo1","Minha Primeira Pagina HTML!");
		model.addAttribute("titulo2","Novo Funcionário");
		model.addAttribute("titulo3","Listar Funcionários");
		model.addAttribute("titulo4","Zodiaco");
		model.addAttribute("titulo5","Rotina Cálculo");
		
		return"index";
	}
}
