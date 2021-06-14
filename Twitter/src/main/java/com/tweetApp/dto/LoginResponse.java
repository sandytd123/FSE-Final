package com.tweetApp.dto;

public class LoginResponse {
	
private String email;

	
	private String errorMessage;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	public void setStatus(boolean status) {
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	


	
	
}