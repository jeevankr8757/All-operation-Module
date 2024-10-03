package com.pro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HistoryController {

	@GetMapping("/history")
	public String test() {
		return "This is the history controller";
	}
}
