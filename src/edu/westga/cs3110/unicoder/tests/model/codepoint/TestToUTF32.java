package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static edu.westga.cs3110.unicoder.helpersfortests.AssertionHelpers.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF32 {

	@Test
	void codepointLen6() {
		Codepoint codepoint = new Codepoint("10FFFE");
		assertEqualsIgnoreCase("0010fffe", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen5() {
		Codepoint codepoint = new Codepoint("1f47d");
		assertEqualsIgnoreCase("0001f47d", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen4() {
		Codepoint codepoint = new Codepoint("147d");
		assertEqualsIgnoreCase("0000147d", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen4OneLeading0() {
		Codepoint codepoint = new Codepoint("0372");
		assertEqualsIgnoreCase("00000372", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen4TwoLeading0() {
		Codepoint codepoint = new Codepoint("0072");
		assertEqualsIgnoreCase("00000072", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen4ThreeLeading0() {
		Codepoint codepoint = new Codepoint("0002");
		assertEqualsIgnoreCase("00000002", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen4AllZeros() {
		Codepoint codepoint = new Codepoint("0000");
		assertEqualsIgnoreCase("00000000", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen5AllZeros() {
		Codepoint codepoint = new Codepoint("00000");
		assertEqualsIgnoreCase("00000000", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen6AllZeros() {
		Codepoint codepoint = new Codepoint("000000");
		assertEqualsIgnoreCase("00000000", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen4AllF() {
		Codepoint codepoint = new Codepoint("ffff");
		assertEqualsIgnoreCase("0000ffff", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen5AllF() {
		Codepoint codepoint = new Codepoint("fffff");
		assertEqualsIgnoreCase("000fffff", codepoint.toUTF32());
	}
	
	@Test
	void codepointLen6AllF() {
		Codepoint codepoint = new Codepoint("ffffff");
		assertEqualsIgnoreCase("00ffffff", codepoint.toUTF32());
	}

}
