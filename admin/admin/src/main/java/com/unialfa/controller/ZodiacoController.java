package com.unialfa.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unialfa.service.ZodiacoService;

@Controller
@RequestMapping("/zodiaco")
public class ZodiacoController {
	
	@Autowired
	ZodiacoService zService;
	
	@GetMapping("/formulario")
	public String abrirFormulario(Model model){
		return "zodiaco/formulario";
	}

	@PostMapping("salvar")
	public String salvar(String nome, String sobreNome, String dataNascimento, Model model) {
				
		model.addAttribute("nome", nome);
		model.addAttribute("sobreNome", sobreNome);
		model.addAttribute("dataNascimento", dataNascimento);
		String signo = zService.descobrirSigno(LocalDate.parse(dataNascimento));
		model.addAttribute("signo", signo);
		model.addAttribute("elemento", zService.descobrirElementoSigno(signo));
		
		System.out.println(nome+sobreNome+dataNascimento);
		
		return abrirSigno(model);
	}
	
	@GetMapping("/signo")
	public String abrirSigno(Model model){
		
		return "zodiaco/signo";
	}
	
		
}
