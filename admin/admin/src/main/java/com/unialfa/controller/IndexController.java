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
}
