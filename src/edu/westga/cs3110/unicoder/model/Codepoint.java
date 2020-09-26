package edu.westga.cs3110.unicoder.model;

/**
 * Handles encoding hex strings as UTF-8, UTF-16, and UTF-32.
 * 
 * @author John Chittam
 *
 */
public class Codepoint {
	
	private int codepoint;

	/**
	 * Converts the given hexString to an int representation and
	 * stores it in this.codepoint
	 * 
	 * @param hexString the hex string to convert and store
	 */
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
	
	/**
	 * Encodes the codepoint as a UTF-16 string
	 * 
	 * @return the encoded UTF-16 string
	 */
	public String toUTF16() {
		if (this.codepoint <= 0xd7ff || (this.codepoint >= 0xe000 && this.codepoint <= 0xffff)) {
			return String.format("%04X", this.codepoint);
		}
		
		int codepointMinus10000 = this.codepoint - 0x10000;
		int highSurrogate = 0xD800 + (codepointMinus10000 >>> 10);
		int lowSurrogate = 0xDC00 + (codepointMinus10000 & 0b00000000001111111111);
		
		return Integer.toHexString(highSurrogate) + Integer.toHexString(lowSurrogate);
	}
	
	/**
	 * Encodes the codepoint as a UTF-8 string
	 * 
	 * @return the encoded UTF-8 string
	 */
	public String toUTF8() {
		if (this.codepoint <= 0x7f) {
			return this.encodeSingleByteUTF8();
		} else if (this.codepoint >= 0x80 && this.codepoint <= 0x7ff) {
			return this.encodeTwoByteUTF8();
		} else if (this.codepoint >= 0x800 && this.codepoint <= 0xffff) {
			return this.encodeThreeByteUTF8();
		}
		
		return this.encodeFourByteUTF8();
	}
	
	private String encodeSingleByteUTF8() {
		return String.format("%02X", this.codepoint);
	}
	
	private String encodeTwoByteUTF8() {
		int byte1 = 0b11000000 | (this.codepoint >>> 6);
		int byte2 = this.performBiwiseOrWith10000000(this.codepoint & 0b00000111111);
		
		return Integer.toHexString(byte1) + Integer.toHexString(byte2);
	}
	
	private String encodeThreeByteUTF8() {
		int byte1 = 0b11100000 | (this.codepoint >>> 12);
		int byte2 = this.performBiwiseOrWith10000000((this.codepoint >>> 6) & 0b0000111111);
		int byte3 = this.performBiwiseOrWith10000000(this.codepoint & 0b000000000000111111);
		
		return Integer.toHexString(byte1) + Integer.toHexString(byte2) + Integer.toHexString(byte3);
	}
	
	private String encodeFourByteUTF8() {
		int byte1 = 0b11110000 | (this.codepoint >>> 18);
		int byte2 = this.performBiwiseOrWith10000000((this.codepoint >>> 12) & 0b000111111);
		int byte3 = this.performBiwiseOrWith10000000((this.codepoint >>> 6) & 0b000000000111111);
		int byte4 = this.performBiwiseOrWith10000000(this.codepoint & 0b000000000000000111111);
		
		return Integer.toHexString(byte1) + Integer.toHexString(byte2)
			   + Integer.toHexString(byte3) + Integer.toHexString(byte4);
	}
	
	private int performBiwiseOrWith10000000(int sixBits) {
		if (sixBits > 0b111111) {
			throw new IllegalArgumentException("don't pass in more than 6 bits");
		}
		
		return sixBits | 0b10000000;
	}

}
