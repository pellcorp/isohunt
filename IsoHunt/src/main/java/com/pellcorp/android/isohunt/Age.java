package com.pellcorp.android.isohunt;

/**
 * Keep it simple for now
 * 
 * @author jason
 *
 */
public class Age {
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
