package com.unialfa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unialfa.model.Curriculo;

@Controller
public class CurriculoController {

	@RequestMapping("/curriculo")
	public String exibir(Model model) {

		
		Curriculo currilo1 = new Curriculo(1112, "Ranghetti", "SI", "UniALFA", "Doscente", 24, "Aplicativos Java");
		Curriculo currilo2 = new Curriculo(1112, "Ranghetti", "SI", "UniALFA", "Doscente", 24, "Aplicativos Java");
		Curriculo currilo3 = new Curriculo(1112, "Ranghetti", "SI", "UniALFA", "Doscente", 24, "Aplicativos Java");

		List<Curriculo> curriculos = new ArrayList<>();
		curriculos.add(currilo1);
		curriculos.add(currilo2);
		curriculos.add(currilo3);
						
		model.addAttribute("curriculos", curriculos);
		

		return "curriculo";
	}

}
