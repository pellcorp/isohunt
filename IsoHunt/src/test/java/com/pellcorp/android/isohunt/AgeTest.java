package com.pellcorp.android.isohunt;

import static org.junit.Assert.*;

import org.junit.Test;

public class AgeTest {
	@Test
	public void testConstructor() {
		Age age = new Age("12.5w");
		assertEquals("12.5w", age.toString());
	}
}
