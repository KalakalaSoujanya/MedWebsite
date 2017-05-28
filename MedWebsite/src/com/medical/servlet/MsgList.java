package com.medical.servlet;

public class MsgList {
	int id;
	String firstName;
	String lastName;
	String date;
	String msgBox;
	String status;
	
	public MsgList() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	







public MsgList(int id,String firstName,String lastName,String date,String msgBox,String status) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.date = date;
		this.msgBox = msgBox;
		this.status = status;
	}

public MsgList(int id, String firstName, String lastName, String date, String msgBox) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.date = date;
	this.msgBox = msgBox;
}









public MsgList( String firstName,String lastName, String date, String msgBox) {
	super();
	
	this.firstName = firstName;
	this.lastName=lastName;
	this.date = date;
	this.msgBox = msgBox;
}





public int getId() {
	return id;
}

public void setId(int id) {
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
