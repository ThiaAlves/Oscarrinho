package com.unialfa.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

import com.unialfa.model.Veiculo;
import com.unialfa.repository.CorRepository;
import com.unialfa.repository.MarcaRepository;
import com.unialfa.repository.UsuarioRepository;
import com.unialfa.repository.VeiculoRepository;
import com.unialfa.util.FileSaver;



@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

	
	@Autowired
	private FileSaver fileSaver;
	
	@Autowired
	VeiculoRepository repo;
	
	@Autowired
	MarcaRepository marcaRepo;
	
	@Autowired
	CorRepository corRepo;
	
	@Autowired
	UsuarioRepository usuarioRepo;
	

	@GetMapping("/formulario")
	public String abrirFormulario(Veiculo veiculo, Model model){
		model.addAttribute("marcas",marcaRepo.findAll());
		model.addAttribute("cores",corRepo.findAll());
		model.addAttribute("usuarios",usuarioRepo.findAll());
		model.addAttribute("tipos",repo.findAll());
		return "veiculo/formulario";
	}
	
	

	@PostMapping("salvar")
	public String salvar(Veiculo veiculo, Model model, final MultipartFile imagem, 
			 @RequestParam(value = "marca_id") Integer marca_id, 
			 @RequestParam(value = "cor_id") Integer cor_id,
			 @RequestParam(value = "usuario_id") Integer usuario_id,
			RedirectAttributes redirectAttribute){

		System.out.print("Inserindo dados no banco");
		System.out.print("--");
		System.out.print("Usuario" + usuario_id);
		System.out.print("--");
		System.out.print("Cor" + cor_id);
		System.out.print("--");
		System.out.print("Foto" + imagem);
		System.out.print("--");

		
		//TODO tratar a inserção de arquivo multipart 
		if (!imagem.isEmpty()) {
			String path = fileSaver.write("img", imagem);
			veiculo.setFotodestaque(path);
		}
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
