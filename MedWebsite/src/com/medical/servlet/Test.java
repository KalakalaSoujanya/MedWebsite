package com.medical.servlet;

import java.util.Date;

public class Test {
	int testId;
	Date d2;
	String testName;
	int doctorId;
	int patientId;
	String doctorNote;
	
	
	public Test() {
		super();
		
	}
	


	public Test(int testId,Date d2,int patientId) {
		super();
		this.testId = testId;
		this.d2 = d2;
		this.patientId = patientId;
	}



	public Test(int testId,Date d2,String testName,int doctorId,int patientId,String doctorNote) {
		super();
		this.testId = testId;
		this.d2 = d2;
		this.testName = testName;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.doctorNote = doctorNote;
	}

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	

	public Date getD2() {
		return d2;
	}

	public void setD2(Date d2) {
		this.d2 = d2;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	

	public String getDoctorNote() {
		return doctorNote;
	}

	public void setDoctorNote(String doctorNote) {
		this.doctorNote = doctorNote;
	}

	

}
