package com.pellcorp.android.isohunt;

import java.io.Serializable;

public class Size implements Serializable {
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
