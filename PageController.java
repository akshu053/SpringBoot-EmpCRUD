package com.indusind.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class PageController {
	
	@GetMapping("/")
	public String getLandingPage() {
		return "index.html";
	}

}
