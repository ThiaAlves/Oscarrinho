package com.unialfa.controller;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unialfa.model.Marca;
import com.unialfa.model.Usuario;
import com.unialfa.repository.MarcaRepository;
import com.unialfa.repository.UsuarioRepository;

@Controller
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	MarcaRepository repo;
	
	@GetMapping("/formulario")
	public String abrirFormulario(Marca marca, Model model){
		return "marca/formulario";
	}
	
	@PostMapping("salvar")
	public String salvar(Marca marca) {
		repo.save(marca);
		return "redirect:lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(Marca marca) {
		repo.save(marca);
		return "redirect:../lista";
	}
	
	@RequestMapping("lista")
	public String abrirLista(Model model) {
		model.addAttribute("marcas",repo.findAll());
		return "marca/lista";
	}
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Marca m = repo.getOne(id);
		model.addAttribute("marca", m);
		
		return "marca/formulario";
	}
	
	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id) {
		repo.deleteById(id);
		return "redirect:../lista";
	}
	
}
