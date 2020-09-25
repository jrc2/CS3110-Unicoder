package edu.westga.cs3110.unicoder.model;

public class Codepoint {
	
	private String hexString;
	private static final int INTEGER_PARSE_RADIX = 16;

	public Codepoint(String hexString) {
		if (!hexString.matches("[0-9a-fA-F]{4,6}")) {
			throw new IllegalArgumentException("The given hex string must be 4-6 characters and "
					+ "only include 0-F (case insensitive)");
		}
		
		this.hexString = hexString.toUpperCase();
	}
	
	/**
	 * Encodes the codepoint as a UTF-32 string
	 * 
	 * @return the encoded UTF-32 string
	 */
	public String toUTF32() {
		int hexStringLength = this.hexString.length();
		int neededLength = 8;
		int numberOfZerosToAdd = neededLength - hexStringLength;
		StringBuilder utf32String = new StringBuilder();
		
		for (int i = 0; i < numberOfZerosToAdd; i++) {
			utf32String.append('0');
		}
		
		utf32String.append(this.hexString);
		
		return utf32String.toString();
	}
}
