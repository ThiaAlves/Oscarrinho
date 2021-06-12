package com.unialfa.controller;

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

import com.unialfa.model.Veiculo;
import com.unialfa.repository.CorRepository;
import com.unialfa.repository.MarcaRepository;
import com.unialfa.repository.UsuarioRepository;
import com.unialfa.repository.VeiculoRepository;
import com.unialfa.service.FotoDestaqueService;



@Controller
@RequestMapping("/veiculo")
public class VeiculoController {

	@Autowired
	VeiculoRepository repo;
	
	@Autowired
	MarcaRepository marcaRepo;
	
	@Autowired
	CorRepository corRepo;
	
	@Autowired
	UsuarioRepository usuarioRepo;
	
	@Autowired
	FotoDestaqueService fotoService;

	@GetMapping("/formulario")
	public String abrirFormulario(Veiculo veiculo, Model model){
		model.addAttribute("marcas",marcaRepo.findAll());
		model.addAttribute("cores",corRepo.findAll());
		model.addAttribute("usuarios",usuarioRepo.findAll());
		model.addAttribute("tipos",repo.findAll());
		return "veiculo/formulario";
	}
	
	

	@PostMapping("salvar")
	public String salvar(Veiculo veiculo, MultipartFile imagemFile, 
			 @RequestParam(value = "marca_id") Integer marca_id, 
			 @RequestParam(value = "cor_id") Integer cor_id,
			 @RequestParam(value = "usuario_id") Integer usuario_id,
			RedirectAttributes redirectAttribute){


			fotoService.uploadFotoDestaqueTarget(imagemFile);
			veiculo.setFotodestaque(fotoService.uploadFotoDestaque(imagemFile));
		
		repo.save(veiculo);
		redirectAttribute.addFlashAttribute("usuarios","showAlert");
		return "redirect:lista"; 
	}

	@PostMapping("editar/salvar")
	public String atualizar(Veiculo veiculo, MultipartFile imagemFile) {
		fotoService.uploadFotoDestaqueTarget(imagemFile);
		veiculo.setFotodestaque(fotoService.uploadFotoDestaque(imagemFile));
		repo.save(veiculo);
		return "redirect:../lista";
	}
	
	@RequestMapping("lista")
	public String abrirLista(Model model) {
		model.addAttribute("veiculos",repo.findAll());
		return "veiculo/lista";
	}
	
	@GetMapping(value = "editar")
	public String editar(@PathParam(value = "id") Long id, Model model, MultipartFile imagem) {
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
