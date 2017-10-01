package com.github.hbas.rules;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.github.hbas.rules.test_utils.BuzzRule;
import com.github.hbas.rules.test_utils.FizzBuzzRule;
import com.github.hbas.rules.test_utils.FizzRule;

public class RuleEngineTest {

	private RuleEngine<FactsWithObjects> engine;

	@Before
	public void setupEngine() {
		this.engine = new RuleEngine<FactsWithObjects>();
		engine.register(new FizzRule());
		engine.register(new BuzzRule());
		engine.register(new FizzBuzzRule());
	}

	@Test
	public void when1_nothing() {
		FactsWithObjects facts = new FactsWithObjects();
		facts.put("number", 1);

		engine.fire(facts);

		assertFalse(facts.is("fizz"));
		assertFalse(facts.is("buzz"));
	}

	@Test
	public void when6_fizz() {
		FactsWithObjects facts = new FactsWithObjects();
		facts.put("number", 6);

		engine.fire(facts);

		assertTrue(facts.is("fizz"));
		assertFalse(facts.is("buzz"));
	}

	@Test
	public void when5_buzz() {
		FactsWithObjects facts = new FactsWithObjects();
		facts.put("number", 5);

		engine.fire(facts);

		assertFalse(facts.is("fizz"));
		assertTrue(facts.is("buzz"));
	}

	@Test
	public void when15_fizzbuzz() {
		FactsWithObjects facts = new FactsWithObjects();
		facts.put("number", 15);

		engine.fire(facts);

		assertTrue(facts.is("fizzbuzz"));
	}

}
