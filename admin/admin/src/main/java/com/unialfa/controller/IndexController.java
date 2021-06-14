package com.unialfa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

	
	
	@RequestMapping("/")
	public String inicar(Model model) {
		return"index";
	}
	@RequestMapping("relatorio/marca")
	public String relMarca(Model model) {
		return"/relatorio/marca";
	}	
	@RequestMapping("relatorio/cor")
	public String relCor(Model model) {
		return"/relatorio/cor";
	}
}
