package com.cypcode.controller_advice_microservice.exception;

public class SubscribeException extends RuntimeException{
	public SubscribeException() {
		super();
	}
	
	public SubscribeException(String message) {
		super(message);
	}
}
