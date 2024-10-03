package com.pro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {

	@GetMapping("/dashboard")
	public String test() {
		return "This is the dashboard controller";
	}
}
