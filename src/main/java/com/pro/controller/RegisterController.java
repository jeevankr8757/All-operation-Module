package com.pro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

	@GetMapping("/register")
	public String test() {
		return "This is the register controller";
	}
}
