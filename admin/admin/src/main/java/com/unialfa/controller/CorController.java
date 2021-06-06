package com.unialfa.controller;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unialfa.model.Cor;
import com.unialfa.repository.CorRepository;

@Controller
@RequestMapping("/cor")
public class CorController {

	@Autowired
	CorRepository repo;
	
	@GetMapping("/formulario")
	public String abrirFormulario(Cor cor, Model model){
		return "cor/formulario";
	}
	
	@PostMapping("salvar")
	public String salvar(Cor cor) {
		repo.save(cor);
		return "redirect:lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(Cor cor) {
		repo.save(cor);
		return "redirect:../lista";
	}
	
	@RequestMapping("lista")
	public String abrirLista(Model model) {
		model.addAttribute("cores",repo.findAll());
		return "cor/lista";
	}
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Cor c = repo.getOne(id);
		model.addAttribute("cor", c);
		
		return "cor/formulario";
	}
	
	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id) {
		repo.deleteById(id);
		return "redirect:../lista";
	}
	
}
