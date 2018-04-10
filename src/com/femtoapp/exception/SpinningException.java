package com.femtoapp.exception;

public class SpinningException extends Exception{

	public String message;
	public SpinningException(String message){
		
		super(message);
		this.message=message;
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
