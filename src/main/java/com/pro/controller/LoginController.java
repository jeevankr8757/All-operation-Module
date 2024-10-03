package com.pro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

	@GetMapping("/login")
	public String test() {
		return "This is the login controller";
	}
}
