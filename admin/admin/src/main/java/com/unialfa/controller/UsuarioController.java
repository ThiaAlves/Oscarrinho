package com.unialfa.controller;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.unialfa.model.Usuario;
import com.unialfa.repository.UsuarioRepository;
import com.unialfa.util.GeradorSenha;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioRepository repo;
	
	@GetMapping("/formulario")
	public String abrirFormulario(Usuario usuario, Model model){
		return "usuario/formulario";
	}
	
	@PostMapping("salvar")
	public String salvar(Usuario usuario, RedirectAttributes redirectAttribute) {

		String senhaOriginal;
		senhaOriginal = usuario.getSenha();
		usuario.setSenha(new GeradorSenha().criptografa(senhaOriginal));
		repo.save(usuario);
		redirectAttribute.addFlashAttribute("mensagem", "Usuario inserido com sucesso!");
		return "redirect:lista";
	}

	@PostMapping("editar/salvar")
	public String atualizar(Usuario usuario, RedirectAttributes redirectAttribute) {
		String senhaOriginal;
		senhaOriginal = usuario.getSenha();
		usuario.setSenha(new GeradorSenha().criptografa(senhaOriginal));
		repo.save(usuario);
		redirectAttribute.addFlashAttribute("mensagem", "Usuario inserido com sucesso!");
		return "redirect:../lista";
	}
	
	@RequestMapping("lista")
	public String abrirLista(Model model) {
		model.addAttribute("usuarios",repo.findAll());
		return "usuario/lista";
	}
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model) {
		Usuario u = repo.getOne(id);
		model.addAttribute("usuario", u);
		
		return "usuario/formulario";
	}
	
	@GetMapping(value = "excluir")
	public String excluir(@PathParam(value = "id") Long id) {
		repo.deleteById(id);
		return "redirect:../lista";
	}
	
}