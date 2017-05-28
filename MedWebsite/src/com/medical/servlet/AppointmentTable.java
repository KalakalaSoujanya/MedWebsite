package com.medical.servlet;

import java.sql.Date;

public class AppointmentTable {
	
	 Date dateSelect;
	 int slotNumber;
	 int doctorId;
	  int patientId;
	public AppointmentTable(int slotNumber) {
		super();
		this.slotNumber = slotNumber;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}
	  
	  
	  
}
 