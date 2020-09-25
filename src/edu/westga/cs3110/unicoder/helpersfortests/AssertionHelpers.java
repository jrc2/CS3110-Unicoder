package edu.westga.cs3110.unicoder.tests.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Helpers to make JUnit testing easier.
 * 
 * @author John Chittam
 *
 */
public class AssertionHelper {
	
	/**
	 * JUnit assertion for checking if two strings are equal, regardless of case
	 * 
	 * @param expected the expected result
	 * @param actual the actual result
	 */
	public static void assertEqualsIgnoreCase(String expected, String actual) {
		assertEquals(expected.toUpperCase(), actual.toUpperCase());
	}
}
