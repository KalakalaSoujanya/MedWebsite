package com.medical.servlet;

public class DoctorPatient {
	int dp_id;
	int patientId;
	int doctorId;
	String status;
	
	
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public DoctorPatient(int patientId, int doctorId, String status) {
		super();
		
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.status = status;
	}
	@Override
	public String toString() {
		return "DoctorPatient [ patientId=" + patientId + ", doctorId=" + doctorId + ", status="+ status + "]";
	}
	
	

}
