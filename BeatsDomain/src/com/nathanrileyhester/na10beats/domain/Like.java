package com.nathanrileyhester.na10beats.domain;

import java.util.Date;

public class Like extends Na10Object {
	private String who;
	private Date time;
	
	public String getWho() {
		return who;
	}
	public void setWho(String who) {
		this.who = who;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
	

}
