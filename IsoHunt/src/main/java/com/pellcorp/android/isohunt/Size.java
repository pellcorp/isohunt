package com.pellcorp.android.isohunt;

public class Size {
	private String size;
	
	/**
	 * ###.## MB or GB
	 * @param value
	 */
	public Size(String value) {
		this.size = value;
	}
	
	public String toString() {
		return size;
	}
}
