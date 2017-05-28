package com.medical.servlet;

public class Patient {
	int patientId;
	String firstName;
	String lastName;
	String emailId;
	String username;
	String password;

	
	
	
	public Patient(String firstName,String lastName,String emailId,String username,String password ){
		this.firstName=firstName;
		this.lastName=lastName;
		this.emailId=emailId;
		this.username=username;
		this.password=password;
		}



	public Patient(int patientId, String firstName, String lastName) {
		super();
		this.patientId = patientId;
		this.firstName = firstName;
		this.lastName = lastName;
		
	}
	



	public Patient(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public int getPatientId() {
		return patientId;
	}



	public void setPatientId(int patientId) {
		this.patientId = patientId;
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



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	

}
