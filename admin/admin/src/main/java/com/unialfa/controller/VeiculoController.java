package com.unialfa.controller;


import java.text.SimpleDateFormat;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.unialfa.model.Usuario;
import com.unialfa.model.Veiculo;
import com.unialfa.repository.MarcaRepository;
import com.unialfa.repository.UsuarioRepository;
import com.unialfa.repository.VeiculoRepository;

@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	VeiculoRepository repo;
	

	@GetMapping("/formulario")
	public String abrirFormulario(Veiculo veiculo, Model model){
		return "veiculo/formulario";
	}
	
	@PostMapping("salvar")
	public String salvar(Veiculo veiculo) {
		repo.save(veiculo);
		return "redirect:lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(Veiculo veiculo) {
		repo.save(veiculo);
		return "redirect:../lista";
	}
	
	
	@RequestMapping("lista")
	public String abrirLista(Model model) {
		model.addAttribute("veiculos",repo.findAll());
		return "veiculo/lista";
	}
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Veiculo v = repo.getOne(id);
		model.addAttribute("veiculo", v);
		
		return "veiculo/formulario";
	}
	
	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id) {
		repo.deleteById(id);
		return "redirect:../lista";
	}
	
}
