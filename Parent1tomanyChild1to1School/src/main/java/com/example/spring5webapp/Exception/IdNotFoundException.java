package com.example.spring5webapp.Exception;

public class IdNotFoundException extends RuntimeException {


	public IdNotFoundException(String message){
		super(message);
	}
	
}
