package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static edu.westga.cs3110.unicoder.helpersfortests.AssertionHelpers.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF32 {

	@Test
	void testCodepointLen6() {
		Codepoint codepoint = new Codepoint("10FFFE");
		assertEqualsIgnoreCase("0010fffe", codepoint.toUTF32());
	}
	
	@Test
	void testCodepointLen5() {
		Codepoint codepoint = new Codepoint("1f47d");
		assertEqualsIgnoreCase("0001f47d", codepoint.toUTF32());
	}
	
	@Test
	void testCodepointLen4() {
		Codepoint codepoint = new Codepoint("147d");
		assertEqualsIgnoreCase("0000147d", codepoint.toUTF32());
	}
	
	@Test
	void testCodepointLen4OneLeading0() {
		Codepoint codepoint = new Codepoint("0372");
		assertEqualsIgnoreCase("00000372", codepoint.toUTF32());
	}
	
	@Test
	void testCodepointLen4TwoLeading0() {
		Codepoint codepoint = new Codepoint("0072");
		assertEqualsIgnoreCase("00000072", codepoint.toUTF32());
	}
	
	@Test
	void testCodepointLen4ThreeLeading0() {
		Codepoint codepoint = new Codepoint("0002");
		assertEqualsIgnoreCase("00000002", codepoint.toUTF32());
	}

}
