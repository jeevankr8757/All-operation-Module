package com.pro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageUploadController {
	
	@GetMapping("/imageUpload")
	public String test() {
		return "This is the imageUpload controller";
	}

}
