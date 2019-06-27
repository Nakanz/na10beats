package com.nathanrileyhester.na10beats.domain;

public class Person extends Na10Object {
	private String first;
	private String last;
	
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
	
	public String toString() {
		return super.toString() + " FirstName [" + getFirst() + "] LastName [" + getLast() + "]";
	}
}
