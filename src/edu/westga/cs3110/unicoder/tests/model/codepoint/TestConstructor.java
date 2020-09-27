package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestConstructor {

	@Test
	void throwsNfeWhenHexStringNull() {
		assertThrows(NumberFormatException.class, () -> {
			new Codepoint(null);
		});
	}
	
	@Test
	void throwsNfeWhenHexStringContainsNonHex() {
		assertThrows(NumberFormatException.class, () -> {
			new Codepoint("GHIKZ");
		});
	}
	
	@Test
	void throwsNfeWhenHexStringEmpty() {
		assertThrows(NumberFormatException.class, () -> {
			new Codepoint("");
		});
	}

}
