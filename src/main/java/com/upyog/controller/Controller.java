package com.upyog.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@GetMapping(path = "/test")
	public String test() {
		return "Hello world from Spring boot!!!";
	}
}
