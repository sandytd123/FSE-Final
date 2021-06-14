package com.tweetApp.dto;

public class ResetPasswordRequestDTO {

private String email;
	
	private String newpassword;
	
	private String oldpassword;
	
	private String succesmessage;
	
	private String errormessage;

	public String getSuccesmessage() {
		return succesmessage;
	}

	public void setSuccesmessage(String succesmessage) {
		this.succesmessage = succesmessage;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}
	
	
	
}
