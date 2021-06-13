package com.unialfa.util;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileSaver {
	@Autowired 
	private HttpServletRequest request;
	
	public String write(String baseFolder, MultipartFile file) {
        try {
        	String realPath = request.getServletContext().getRealPath("/" + baseFolder);
        	System.out.println("realPath" + realPath);
            String path = realPath + "/" + file.getOriginalFilename();
            System.out.println("path: " + path);
            file.transferTo(new File(path));
            System.out.println("Caminho gravado no banco: " + baseFolder + "/" + file.getOriginalFilename());
            return baseFolder + "/" + file.getOriginalFilename();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public String uploadFotoDestaqueTarget(MultipartFile file) {
		try {
			String url = getClass().getResource("/static/img/veiculos").toString();
			url = url.replace("file/", "");
			Path path = Paths.get(url + "/" + StringUtils.cleanPath(file.getOriginalFilename()));
			byte[] bytes = file.getBytes();
			Files.write(path, bytes);
			
			return file.getOriginalFilename();
		} catch (Exception e) {
			e.printStackTrace();
			return "default.png";
		}
		
	}
	
	
	
}
