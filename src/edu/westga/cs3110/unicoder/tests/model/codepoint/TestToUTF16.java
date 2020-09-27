package edu.westga.cs3110.unicoder.tests.model.codepoint;

import static edu.westga.cs3110.unicoder.helpersfortests.AssertionHelpers.assertEqualsIgnoreCase;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs3110.unicoder.model.Codepoint;

class TestToUTF16 {

	@Test
	void codepointLen4Part1LowerBound() {
		Codepoint codepoint = new Codepoint("0000");
		
		assertEqualsIgnoreCase("0000", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen4Part1UpperBound() {
		Codepoint codepoint = new Codepoint("d7ff");
		
		assertEqualsIgnoreCase("d7ff", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen4Part1() {
		Codepoint codepoint = new Codepoint("6f5c");
		
		assertEqualsIgnoreCase("6f5c", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen4Part2LowerBound() {
		Codepoint codepoint = new Codepoint("e000");
		
		assertEqualsIgnoreCase("e000", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen4Part2UpperBound() {
		Codepoint codepoint = new Codepoint("ffff");
		
		assertEqualsIgnoreCase("ffff", codepoint.toUTF16());
	}
	
	@Test
	void codepointLen4Part2() {
		Codepoint codepoint = new Codepoint("e780");
		
		assertEqualsIgnoreCase("e780", codepoint.toUTF16());
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
	
	@Test
	void lotsOfLeadingZeros() {
		Codepoint codepoint = new Codepoint("00000000000000000000000000000001");
		
		assertEqualsIgnoreCase("0001", codepoint.toUTF16());
	}
	
	@Test
	void codepointAtStartOfGap() {
		Codepoint codepoint = new Codepoint("d800");
		
		assertThrows(IllegalArgumentException.class, () -> {
			codepoint.toUTF16();
		});
	}
	
	@Test
	void codepointAtEndOfGap() {
		Codepoint codepoint = new Codepoint("dfff");
		
		assertThrows(IllegalArgumentException.class, () -> {
			codepoint.toUTF16();
		});
	}
	
	@Test
	void codepointInGap() {
		Codepoint codepoint = new Codepoint("dd4e");
		
		assertThrows(IllegalArgumentException.class, () -> {
			codepoint.toUTF16();
		});
	}
	
	@Test
	void codepointOneTooBig() {
		Codepoint codepoint = new Codepoint("110000");
		
		assertThrows(IllegalArgumentException.class, () -> {
			codepoint.toUTF16();
		});
	}
	
	@Test
	void codepointWayTooBig() {
		Codepoint codepoint = new Codepoint("FFFFFF");
		
		assertThrows(IllegalArgumentException.class, () -> {
			codepoint.toUTF16();
		});
	}

}
