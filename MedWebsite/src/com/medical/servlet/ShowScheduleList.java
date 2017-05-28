package com.medical.servlet;

public class ShowScheduleList {
	
String first;
String last;
String dateSelection;
String slotNoIndex;
public ShowScheduleList(String first, String last, String dateSelection, String slotNoIndex) {
	super();
	this.first = first;
	this.last = last;
	this.dateSelection = dateSelection;
	this.slotNoIndex = slotNoIndex;
}
public String getFirst() {
	return first;
}
public void setFirst(String first) {
	this.first = first;
}
public String getLast() {
	return last;
}
public void setLast(String last) {
	this.last = last;
}
public String getDateSelection() {
	return dateSelection;
}
public void setDateSelection(String dateSelection) {
	this.dateSelection = dateSelection;
}
public String getSlotNoIndex() {
	return slotNoIndex;
}
public void setSlotNoIndex(String slotNoIndex) {
	this.slotNoIndex = slotNoIndex;
}



}
