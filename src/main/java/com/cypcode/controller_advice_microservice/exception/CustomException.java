package com.cypcode.controller_advice_microservice.exception;


public class CustomException extends RuntimeException{
	public CustomException() {
		super();
	}
	
	public CustomException(String message) {
		super(message);
	}	

}
