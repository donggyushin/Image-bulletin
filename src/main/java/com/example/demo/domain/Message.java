package com.example.demo.domain;

public class Message {
	
	private String errorMessage;
	private String SuccessMessage;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getSuccessMessage() {
		return SuccessMessage;
	}
	public void setSuccessMessage(String successMessage) {
		SuccessMessage = successMessage;
	}
	@Override
	public String toString() {
		return "Message [errorMessage=" + errorMessage + ", SuccessMessage=" + SuccessMessage + "]";
	}
	
	

}
