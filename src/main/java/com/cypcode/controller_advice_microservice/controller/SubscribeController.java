package com.cypcode.controller_advice_microservice.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cypcode.controller_advice_microservice.exception.CustomException;
import com.cypcode.controller_advice_microservice.exception.SubscribeException;

@RestController
@RequestMapping("subscribe")
public class SubscribeController {


	@GetMapping
	public ResponseEntity<?> subscribe(){
//		todo add your custom logic
		throw new SubscribeException("Subscribe failed");
	}
	
	@PostMapping
	public ResponseEntity<?> subscribePost(){
//		todo add your custom logic
		throw new CustomException("Subscribe Post failed");
	}
}
