package com.pellcorp.android.isohunt;

import java.io.Serializable;

public class Result implements Serializable {
	private String id;
	private Category category;
	private Age age;
	private String title;
	private Rating rating;
	private Size size;
	private int seeders;
	private int leeches;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Category getCategory() {
		return category;
	}
	
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Age getAge() {
		return age;
	}
	
	public void setAge(Age age) {
		this.age = age;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Rating getRating() {
		return rating;
	}
	
	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public Size getSize() {
		return size;
	}
	
	public void setSize(Size size) {
		this.size = size;
	}
	
	public int getSeeders() {
		return seeders;
	}
	
	public void setSeeders(int seeders) {
		this.seeders = seeders;
	}
	
	public int getLeeches() {
		return leeches;
	}
	
	public void setLeeches(int leeches) {
		this.leeches = leeches;
	}
}
