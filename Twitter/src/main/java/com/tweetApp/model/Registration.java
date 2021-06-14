package com.tweetApp.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;



@DynamoDBTable(tableName = "register")
public class Registration {
	
	@DynamoDBHashKey
	private String id;
	
	@NotEmpty(message = "firstname not be empty")
	@DynamoDBAttribute
	private String firstName;
	
	@DynamoDBAttribute
	@NotEmpty(message = "Lastname not be empty")
	private String lastName;
	
	@DynamoDBAttribute
	@NotNull
	private String gender;
	
	@Email @NotEmpty 
	@DynamoDBAttribute
	private String email;
	
	@NotEmpty
	private String password;
	
	@NotEmpty
	@DynamoDBAttribute
	private String contactNo;
	
	public Registration()
	{
		
	}

	public Registration(String id, @NotEmpty(message = "firstname not be empty") String firstName,
			@NotEmpty(message = "Lastname not be empty") String lastName, @NotNull String gender,
			@Email @NotEmpty String email, @NotEmpty String password, @NotEmpty String contactNo) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	@Override
	public String toString() {
		return "Registration [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", email=" + email + ", password=" + password + ", contactNo=" + contactNo + "]";
	}

	
	

	
}
