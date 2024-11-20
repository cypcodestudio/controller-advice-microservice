package com.cypcode.controller_advice_microservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cypcode.controller_advice_microservice.exception.CustomException;
import com.cypcode.controller_advice_microservice.exception.HomeException;

@RestController
@RequestMapping("home")
public class HomeController {

	@GetMapping
	public ResponseEntity<?> home(){
//		todo add custom logic
		throw new HomeException("Home failed");
	}
	
	@PostMapping
	public ResponseEntity<?> homePost(){
//		add your custom logic
		throw new CustomException("Home Post failed");
	}
}
