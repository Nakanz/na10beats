package com.nathanrileyhester.na10beats.domain;

import java.util.*;

public class Track {
	private String name;
	private byte[] track;
	private Author author;
	private ArrayList<Like> likes;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getTrack() {
		return track;
	}
	public void setTrack(byte[] track) {
		this.track = track;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public ArrayList<Like> getLikes() {
		return likes;
	}
	public void setLikes(ArrayList<Like> likes) {
		this.likes = likes;
	}
	
	

}
