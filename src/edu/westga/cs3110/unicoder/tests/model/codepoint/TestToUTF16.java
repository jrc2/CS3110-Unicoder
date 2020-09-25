package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static edu.westga.cs3110.unicoder.helpersfortests.AssertionHelpers.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF16 {

	@Test
	void codepointLen4() {
		Codepoint codepoint = new Codepoint("abcd");
		
		assertEqualsIgnoreCase("ABCD", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen4OneLeading0() {
		Codepoint codepoint = new Codepoint("0bcd");
		
		assertEqualsIgnoreCase("0BCD", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen4TwoLeading0() {
		Codepoint codepoint = new Codepoint("00cd");
		
		assertEqualsIgnoreCase("00CD", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen4ThreeLeading0() {
		Codepoint codepoint = new Codepoint("000d");
		
		assertEqualsIgnoreCase("000D", codepoint.toUTF16());
	}
	
	@Test
	void codepoint4Zeros() {
		Codepoint codepoint = new Codepoint("0000");
		
		assertEqualsIgnoreCase("0000", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen5LowerBound() {
		Codepoint codepoint = new Codepoint("10000");
		
		assertEqualsIgnoreCase("d800dc00", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen5UpperBound() {
		Codepoint codepoint = new Codepoint("fffff");
		
		assertEqualsIgnoreCase("dbbfdfff", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen5() {
		Codepoint codepoint = new Codepoint("7bbe5");
		
		assertEqualsIgnoreCase("d9aedfe5", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen6LowerBound() {
		Codepoint codepoint = new Codepoint("100000");
		
		assertEqualsIgnoreCase("dbc0dc00", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen6UpperBound() {
		Codepoint codepoint = new Codepoint("10ffff");
		
		assertEqualsIgnoreCase("dbffdfff", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen6() {
		Codepoint codepoint = new Codepoint("10980d");
		
		assertEqualsIgnoreCase("dbe6dc0d", codepoint.toUTF16());
	}

}
