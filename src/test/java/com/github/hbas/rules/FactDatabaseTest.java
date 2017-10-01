package com.github.hbas.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactDatabaseTest {

	protected FactDatabase getFacts() {
		return new FactDatabase();
	}

	@Test
	public void tellAndCheck() {
		FactDatabase facts = getFacts();
		facts.tell("something");
		facts.isNot("x");
		assertTrue(facts.is("something"));
		assertFalse(facts.is("something else"));
		assertFalse(facts.is("x"));
	}

}
