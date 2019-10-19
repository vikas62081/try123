package com.virtusa.shoppersden.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	public void uploadFile(MultipartFile file) {
		String folder = System.getProperty("user.dir")+"/src/main/resources/static/images/products/";
		try {
			byte[] bytes=file.getBytes();
			Path path=Paths.get(folder+file.getOriginalFilename());
			Files.write(path, bytes);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace(); 
		}
	}
	
}


Controller code:

@PostMapping("/addproduct")
	public String addProduct(@RequestParam MultipartFile imageURL) {
		fileUploadService.uploadFile(imageURL);
		
	}