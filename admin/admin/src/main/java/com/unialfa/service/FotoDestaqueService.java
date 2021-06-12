package com.unialfa.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoDestaqueService {

	//Constante com o caminho de uma pasta local
	private final String uploadDir = "/var/www/html/oscarrinho/images/veiculos/";
	private final String uploadDirJava = "/home/thiago/" + "Área de Trabalho" + "/oscarrinho/admin/admin/target/classes/static/img/veiculos/";

	public String getUploadDir() {
		return uploadDir;
	}
	public String getUploadDirJava() {
		return uploadDirJava;
	}

	// Esse método salva o arquivo em uma pasta local
	public String uploadFotoDestaque(MultipartFile file) {
		try {
			Path path = Paths.get(uploadDir + StringUtils.cleanPath(file.getOriginalFilename()));
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			return file.getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			return "logomarca.png";
		}
	}

	// Esse método salva o arquivo no projeto a partir da pasta target
	public String uploadFotoDestaqueTarget(MultipartFile file) {
		try {
			Path path = Paths.get(uploadDirJava + StringUtils.cleanPath(file.getOriginalFilename()));
			Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

			return file.getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			return "logomarca.png";
		}
	}
}
