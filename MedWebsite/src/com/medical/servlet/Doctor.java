package com.medical.servlet;

public class Doctor {
		int doctorId;
		String firstName;
		String lastName;
		String title;
		String speciality;
		String emailId;
		String officeStreet;
		String address;
		String officeCity;
		String officeState;
		String username;
		String password;
		
		public Doctor(int doctorId,String firstName,String lastName,String title,String speciality,String emailId,String officeStreet,String address,String officeCity,String officeState,String username,String password){
		this.doctorId=doctorId;
		this.firstName=firstName;
		this.lastName=lastName;
		this.title= title;
		this.speciality= speciality;
		this.emailId=emailId;
		this.officeStreet=officeStreet;
		this.address= address;
		this.officeCity= officeCity;
		this.officeState= officeState;
		this.username= username;
		this.password= password;
		
		}
		public Doctor(int doctorId,String firstName,String lastName,String title,String speciality){
			this.doctorId=doctorId;
			this.firstName=firstName;
			this.lastName=lastName;
			this.title=title;
			this.speciality=speciality;
			}
		
		
		public Doctor(String firstName, String lastName) {
			super();
			this.firstName = firstName;
			this.lastName = lastName;
		}
		public int getDoctorId() {
			return doctorId;
		}
		public void setDoctorId(int doctorId) {
			this.doctorId = doctorId;
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
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getSpeciality() {
			return speciality;
		}
		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}
		public String getEmailId() {
			return emailId;
		}
		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}
		public String getOfficeStreet() {
			return officeStreet;
		}
		
		public void setOfficeStreet(String officeStreet) {
			this.officeStreet=officeStreet;
		}
		
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getOfficeCity() {
			return officeCity;
		}
		public void setOfficeCity(String officeCity) {
			this.officeCity = officeCity;
		}
		public String getOfficeState() {
			return officeState;
		}
		public void setOfficeState(String officeState) {
			this.officeState = officeState;
		}
		public String getUserName() {
			return username;
		}
		public void setUserName(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}

	}
