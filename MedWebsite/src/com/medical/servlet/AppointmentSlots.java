package com.medical.servlet;

import java.util.ArrayList;
import java.util.List;

public class AppointmentSlots {
	
	
	
	public AppointmentSlots() {
		super();
		
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
	
	
}

