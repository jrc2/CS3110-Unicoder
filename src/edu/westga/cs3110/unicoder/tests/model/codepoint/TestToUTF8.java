package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static edu.westga.cs3110.unicoder.helpersfortests.AssertionHelpers.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF8 {

	@Test
	void singleByteLowerBound() {
		Codepoint codepoint = new Codepoint("0");
		
		assertEqualsIgnoreCase("00", codepoint.toUTF8());
	}
	
	@Test
	void singleByteLowerBoundLeadingZeros() {
		Codepoint codepoint = new Codepoint("0000000000");
		
		assertEqualsIgnoreCase("00", codepoint.toUTF8());
	}
	
	@Test
	void singleByteUpperBound() {
		Codepoint codepoint = new Codepoint("7f");
		
		assertEqualsIgnoreCase("7f", codepoint.toUTF8());
	}
	
	@Test
	void singleByte() {
		Codepoint codepoint = new Codepoint("2b");
		
		assertEqualsIgnoreCase("2B", codepoint.toUTF8());
	}
	
	@Test
	void twoBytesLowerBound() {
		Codepoint codepoint = new Codepoint("80");
		
		assertEqualsIgnoreCase("c280", codepoint.toUTF8());
	}
	
	@Test
	void twoBytesUpperBound() {
		Codepoint codepoint = new Codepoint("7ff");
		
		assertEqualsIgnoreCase("dfbf", codepoint.toUTF8());
	}
	
	@Test
	void twoBytes() {
		Codepoint codepoint = new Codepoint("50f");
		
		assertEqualsIgnoreCase("d48f", codepoint.toUTF8());
	}
	
	@Test
	void threeBytesLowerBound() {
		Codepoint codepoint = new Codepoint("800");
		
		assertEqualsIgnoreCase("e0a080", codepoint.toUTF8());
	}
	
	@Test
	void threeBytesUpperBound() {
		Codepoint codepoint = new Codepoint("ffff");
		
		assertEqualsIgnoreCase("efbfbf", codepoint.toUTF8());
	}
	
	@Test
	void threeBytes() {
		Codepoint codepoint = new Codepoint("bfbf");
		
		assertEqualsIgnoreCase("ebbebf", codepoint.toUTF8());
	}
	
	@Test
	void fourBytesLowerBound() {
		Codepoint codepoint = new Codepoint("10000");
		
		assertEqualsIgnoreCase("f0908080", codepoint.toUTF8());
	}
	
	@Test
	void fourBytesUpperBound() {
		Codepoint codepoint = new Codepoint("10ffff");
		
		assertEqualsIgnoreCase("f48fbfbf", codepoint.toUTF8());
	}
	
	@Test
	void fourBytes() {
		Codepoint codepoint = new Codepoint("10ea6a");
		
		assertEqualsIgnoreCase("f48ea9aa", codepoint.toUTF8());
	}

}
