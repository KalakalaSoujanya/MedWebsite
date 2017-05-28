package com.medical.servlet;

public class Message {
	int msgId;
	int patientId;
	int doctorId;
	String sender;
	String date;
	String msgBox;
	String status;
	public Message(int msgId, int patientId, int doctorId, String sender, String date, String msgBox, String status) {
		super();
		this.msgId = msgId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.sender = sender;
		this.date = date;
		this.msgBox = msgBox;
		this.status = status;
	}
	public Message(int msgId, int patientId, int doctorId, String msgBox) {
		super();
		this.msgId = msgId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.msgBox = msgBox;
	}
	public Message(String sender, String date, String msgBox) {
		super();
		this.sender = sender;
		this.date = date;
		this.msgBox = msgBox;
	}
	
	public Message(int patientId, int doctorId, String sender, String date, String msgBox) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.sender = sender;
		this.date = date;
		this.msgBox = msgBox;
	}
	
	public Message(String date, String msgBox) {
		super();
		this.date = date;
		this.msgBox = msgBox;
	}
	
	public int getMsgId() {
		return msgId;
	}
	public void setMsgId(int msgId) {
		this.msgId = msgId;
	}
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
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMsgBox() {
		return msgBox;
	}
	public void setMsgBox(String msgBox) {
		this.msgBox = msgBox;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
