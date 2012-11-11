package com.pellcorp.android.isohunt;

import java.io.Serializable;

/**
 * Keep it simple for now
 * 
 * @author jason
 *
 */
public class Age implements Serializable {
	private String value;
	
	/**
	 * 120.5w
	 * 2.5d	
	 * @param ageValue
	 */
	public Age(String value) {
		this.value = value;
	}
	
	public String toString() {
		return value;
	}
}
