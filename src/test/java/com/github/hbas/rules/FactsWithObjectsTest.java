package com.github.hbas.rules;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactsWithObjectsTest extends FactDatabaseTest {

	@Override
	protected FactsWithObjects getFacts() {
		return new FactsWithObjects();
	}

	@Test
	public void canHaveParameters() {
		FactsWithObjects facts = getFacts();
		facts.put("age", 30);
		int age = facts.get(Integer.class, "age");
		assertEquals(30, age);
	}

}
