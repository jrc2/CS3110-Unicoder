package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestConstructor {

	@Test
	void throwsIaeIfMoreThan6Chars() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("1234567");
		});
	}
	
	@Test
	void throwsIaeIfLessThan4Chars() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Codepoint("123");
		});
	}
	
	@Test
	void allows4Chars() {
		assertDoesNotThrow(() -> {
			new Codepoint("0123");
		});
	}
	
	@Test
	void allows5Chars() {
		assertDoesNotThrow(() -> {
			new Codepoint("01234");
		});
	}
	
	@Test
	void allows6Chars() {
		assertDoesNotThrow(() -> {
			new Codepoint("012345");
		});
	}
	
	@Test
	void allows6Through9() {
		assertDoesNotThrow(() -> {
			new Codepoint("6789");
		});
	}
	
	@Test
	void allowsAThroughFCaseInsensitive() {
		assertDoesNotThrow(() -> {
			new Codepoint("ABCDEF");
			new Codepoint("abcdef");
		});
	}

}
