package edu.westga.cs3110.unicoder.model;

public class Codepoint {
	
	private int codepoint;

	public Codepoint(String hexString) {
		this.codepoint = Integer.parseUnsignedInt(hexString, 16);
	}
	
	/**
	 * Encodes the codepoint as a UTF-32 string
	 * 
	 * @return the encoded UTF-32 string
	 */
	public String toUTF32() {
		return String.format("%08X", this.codepoint);
	}
	
	public String toUTF16() {
		if (this.codepoint <= 0xd7ff || (this.codepoint >= 0xe000 && this.codepoint <= 0xffff)) {
			return String.format("%04X", this.codepoint);
		}
		
		int p = this.codepoint - 0x10000;
		int highSurrogate = 0xD800 + (p >>> 10);
		int lowSurrogate = 0xDC00 + (p & 0b00000000001111111111);
		
		return Integer.toHexString(highSurrogate) + Integer.toHexString(lowSurrogate);
	}
}
