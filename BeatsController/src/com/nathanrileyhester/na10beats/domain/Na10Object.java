package com.nathanrileyhester.na10beats.domain;

public abstract class Na10Object {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + " ID [" + getId() + "]";
	}
}
