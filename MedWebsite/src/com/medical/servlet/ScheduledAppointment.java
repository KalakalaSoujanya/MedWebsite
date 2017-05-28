package com.medical.servlet;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ScheduledAppointment {
	
	String firstName;
	
	String lastName;
	Date dateSelect;
	int slotNumber;
	String slotNoIndex;
	
	public ScheduledAppointment() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public List<String> slotList(){
		List<String> slots=new ArrayList<String>();
		slots.add("9:30-10:00");
		slots.add("10:00-10:30");
		slots.add("10:30-11:00");
		slots.add("11:00-11:30");
		slots.add("11:30-12:00");
		slots.add("12:00-12:30");
		slots.add("1:00-1:30");
		slots.add("1:30-2:00");
		slots.add("2:30-3:00");
		slots.add("3:00-3:30");
		slots.add("3:30-4:00");
		slots.add("4:00-4:30");
		slots.add("4:30-5:00");
		return slots;
	}


	public ScheduledAppointment(String firstName, String lastName, Date dateSelect, int slotNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateSelect = dateSelect;
		this.slotNumber = slotNumber;
		this.slotNoIndex=slotList().get(slotNumber-1);
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
	public Date getDateSelect() {
		return dateSelect;
	}
	public void setDateSelect(Date dateSelect) {
		this.dateSelect = dateSelect;
	}
	public int getSlotNumber() {
		return slotNumber;
	}
	public void setSlotNumber(int slotNumber) {
		this.slotNumber = slotNumber;
	}public String getSlotNoIndex() {
		return slotNoIndex;
	}


	public void setSlotNoIndex(String slotNoIndex) {
		this.slotNoIndex = slotNoIndex;
	}
	
}
	